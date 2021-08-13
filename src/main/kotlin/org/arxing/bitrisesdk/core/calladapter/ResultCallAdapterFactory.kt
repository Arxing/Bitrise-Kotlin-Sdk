package org.arxing.bitrisesdk.core.calladapter

import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.CallAdapter.Factory
import retrofit2.Retrofit
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type
import org.arxing.bitrisesdk.core.result.SimpleResult

class ResultCallAdapterFactory private constructor() : Factory() {

  companion object {

    fun create(): ResultCallAdapterFactory {
      return ResultCallAdapterFactory()
    }
  }

  override fun get(
    returnType: Type,
    annotations: Array<out Annotation>,
    retrofit: Retrofit
  ): CallAdapter<*, *>? {
    return when (getRawType(returnType)) {
      Call::class.java -> {
        val callType = getParameterUpperBound(0, returnType as ParameterizedType)
        when (getRawType(callType)) {
          SimpleResult::class.java -> {
            val resultType = getParameterUpperBound(0, callType as ParameterizedType)
            ResultCallAdapter(getRawType(resultType))
          }
          else -> null
        }
      }
      else -> null
    }
  }
}
