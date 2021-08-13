package org.arxing.bitrisesdk.core.result

sealed class SimpleResult<T> {

  private class Success<T>(val value: T) : SimpleResult<T>()

  private class Failure<T>(val exception: Throwable) : SimpleResult<T>()

  companion object {

    fun <T> success(value: T): SimpleResult<T> {
      return Success(value)
    }

    fun <T> failure(error: Throwable): SimpleResult<T> {
      return Failure(error)
    }
  }

  val isSuccess: Boolean get() = this is Success

  val isFailure: Boolean get() = this is Failure

  fun getOrNull(): T? = when (this) {
    is Failure -> null
    is Success -> value
  }

  fun exceptionOrNull(): Throwable? = when (this) {
    is Failure -> exception
    is Success -> null
  }

  fun getOrThrow(): T = when (this) {
    is Failure -> throw exception
    is Success -> value
  }

  fun getOrElse(onFailure: (exception: Throwable) -> T): T = when (this) {
    is Failure -> onFailure.invoke(exception)
    is Success -> value
  }

  fun getOrDefault(defaultValue: T): T = when (this) {
    is Failure -> defaultValue
    is Success -> value
  }

  fun <R> map(transform: (T) -> R): SimpleResult<R> = when (this) {
    is Failure -> failure(exception)
    is Success -> success(transform(value))
  }

  fun onSuccess(action: (T) -> Unit): SimpleResult<T> = when (this) {
    is Failure -> this
    is Success -> {
      action(value)
      this
    }
  }

  fun onFailure(action: (Throwable) -> Unit): SimpleResult<T> = when (this) {
    is Failure -> {
      action(exception)
      this
    }
    is Success -> this
  }

  override fun toString(): String {
    return when (this) {
      is Failure -> "Failure($exception)"
      is Success -> "Success($value)"
    }
  }
}
