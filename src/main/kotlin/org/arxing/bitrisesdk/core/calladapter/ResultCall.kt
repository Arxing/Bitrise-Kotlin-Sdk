package org.arxing.bitrisesdk.core.calladapter

import com.google.gson.Gson
import org.arxing.bitrisesdk.core.model.error.BitriseError
import org.arxing.bitrisesdk.core.model.error.BitriseErrorEntity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import org.arxing.bitrisesdk.core.result.SimpleResult

class ResultCall<T>(private val proxy: Call<T>) : CallDelegate<T, SimpleResult<T>>(proxy) {

  override fun clone(): Call<SimpleResult<T>> {
    return ResultCall(proxy.clone())
  }

  override fun execute(): Response<SimpleResult<T>> {
    return convertResponse(proxy.execute())
  }

  override fun enqueue(callback: Callback<SimpleResult<T>>) {
    proxy.enqueue(object : Callback<T> {
      override fun onResponse(call: Call<T>, response: Response<T>) {
        callback.onResponse(this@ResultCall, convertResponse(response))
      }

      override fun onFailure(call: Call<T>, t: Throwable) {
        t.printStackTrace()
        callback.onResponse(this@ResultCall, Response.success(SimpleResult.failure(t)))
      }
    })
  }

  private fun convertResponse(from: Response<T>): Response<SimpleResult<T>> {
    val result: SimpleResult<T> = if (from.isSuccessful) {
      val body = from.body()!!
      SimpleResult.success(body)
    } else {
      val errorCode = from.code()
      val errorEntity = Gson().fromJson(
        from.errorBody()!!.charStream(),
        BitriseErrorEntity::class.java
      )
      SimpleResult.failure(BitriseError(errorCode = errorCode, errorEntity = errorEntity))
    }
    return Response.success(result)
  }
}
