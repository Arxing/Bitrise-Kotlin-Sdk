package org.arxing.bitrisesdk

import okhttp3.OkHttpClient
import org.arxing.bitrisesdk.core.Constants
import org.arxing.bitrisesdk.core.calladapter.ResultCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

class BitriseSdk(private val personalToken: String) {
  val retrofit: Retrofit by lazyOf(createRetrofit())

  private fun createRetrofit(): Retrofit = Retrofit.Builder()
    .baseUrl(BITRISE_API_URL)
    .addCallAdapterFactory(ResultCallAdapterFactory.create())
    .addConverterFactory(ScalarsConverterFactory.create())
    .addConverterFactory(GsonConverterFactory.create())
    .client(createClient())
    .build()

  private fun createClient(): OkHttpClient = OkHttpClient.Builder()
    .addInterceptor {
      val request = it.request()
        .newBuilder()
        .header(Constants.AUTHORIZATION, personalToken)
        .build()
      it.proceed(request)
    }
    .build()

  inline fun <reified T> getService(): T {
    return retrofit.create(T::class.java)
  }

  companion object {
    private const val BITRISE_API_URL = "https://api.bitrise.io/"
  }
}
