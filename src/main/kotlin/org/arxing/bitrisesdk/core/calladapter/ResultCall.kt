package org.arxing.bitrisesdk.core.calladapter

import com.google.gson.Gson
import org.arxing.bitrisesdk.core.model.error.BitriseError
import org.arxing.bitrisesdk.core.model.error.BitriseErrorEntity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import org.arxing.bitrisesdk.core.result.Result

class ResultCall<T>(private val proxy: Call<T>) : CallDelegate<T, Result<T>>(proxy) {

  override fun clone(): Call<Result<T>> {
    return ResultCall(proxy.clone())
  }

  override fun execute(): Response<Result<T>> {
    return convertResponse(proxy.execute())
  }

  override fun enqueue(callback: Callback<Result<T>>) {
    proxy.enqueue(object : Callback<T> {
      override fun onResponse(call: Call<T>, response: Response<T>) {
        callback.onResponse(this@ResultCall, convertResponse(response))
      }

      override fun onFailure(call: Call<T>, t: Throwable) {
        t.printStackTrace()
        callback.onResponse(this@ResultCall, Response.success(Result.failure(t)))
      }
    })
  }

  private fun convertResponse(from: Response<T>): Response<Result<T>> {
    val result: Result<T> = if (from.isSuccessful) {
      val body = from.body()!!
      Result.success(body)
    } else {
      val errorCode = from.code()
      val errorEntity = Gson().fromJson(
        from.errorBody()!!.charStream(),
        BitriseErrorEntity::class.java
      )
      Result.failure(BitriseError(errorCode = errorCode, errorEntity = errorEntity))
    }
    return Response.success(result)
  }
}
