package org.arxing.bitrisesdk.core.result

sealed class Result<T> {

  private class Success<T>(val value: T) : Result<T>()

  private class Failure<T>(val error: Throwable) : Result<T>()

  companion object {

    fun <T> success(value: T): Result<T> {
      return Success(value)
    }

    fun <T> failure(error: Throwable): Result<T> {
      return Failure(error)
    }
  }

  fun toKotlinResult(): kotlin.Result<T> {
    return when (this) {
      is Success -> kotlin.Result.success(value)
      is Failure -> kotlin.Result.failure(error)
    }
  }

  override fun toString(): String {
    return when (this) {
      is Failure -> "Failure($error)"
      is Success -> "Success($value)"
    }
  }
}
