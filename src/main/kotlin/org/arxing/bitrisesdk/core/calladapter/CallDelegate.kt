package org.arxing.bitrisesdk.core.calladapter

import okhttp3.Request
import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

abstract class CallDelegate<T, R>(
  private val proxy: Call<T>
) : Call<R> {

  abstract override fun clone(): Call<R>

  abstract override fun execute(): Response<R>

  abstract override fun enqueue(callback: Callback<R>)

  override fun isExecuted(): Boolean = proxy.isExecuted

  override fun cancel() = proxy.cancel()

  override fun isCanceled(): Boolean = proxy.isCanceled

  override fun request(): Request = proxy.request()

  override fun timeout(): Timeout = proxy.timeout()
}
