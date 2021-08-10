package org.arxing.bitrisesdk.core.calladapter

import retrofit2.Call
import retrofit2.CallAdapter
import java.lang.reflect.Type
import org.arxing.bitrisesdk.core.result.Result

class ResultCallAdapter<T>(
  private val clazz: Class<T>
) : CallAdapter<T, Call<Result<T>>> {

  override fun responseType(): Type = clazz

  override fun adapt(call: Call<T>): Call<Result<T>> {
    return ResultCall(call)
  }
}
