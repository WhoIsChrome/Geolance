package com.chrome.geolance.core.network

import com.chrome.geolance.core.Either
import com.google.gson.Gson
import com.google.gson.JsonParseException
import okhttp3.ResponseBody
import retrofit2.HttpException
import java.io.IOException
import java.util.*

typealias NetworkResponse<T> = Either<NetworkFailure, T>

sealed class NetworkFailure {

    abstract val exception: Exception?

    class NoConnection(override val exception: Exception) : NetworkFailure() {
        override fun equals(other: Any?): Boolean =
            other is NoConnection && exception.isEquals(other.exception)

        override fun hashCode(): Int =
            exception.stackTrace.sumOf(StackTraceElement::hashCode)

        override fun toString(): String =
            "NoConnection(exception=$exception)"
    }

    class HttpFailure(
        val code: Int,
        val message: String,
        val backendError: BackendError? = null,
        override val exception: Exception?,
    ) : NetworkFailure() {

        constructor(httpException: HttpException, backendError: BackendError?) : this(
            code = httpException.code(),
            message = httpException.message(),
            backendError = backendError,
            exception = httpException
        )

        override fun equals(other: Any?): Boolean =
            other is HttpFailure
                    && code == other.code
                    && message == other.message
                    && backendError == other.backendError
                    && exception.isEquals(other.exception)

        override fun hashCode(): Int {
            var result = 31 * message.hashCode() + code
            result = 31 * result + backendError.hashCode()
            result = 31 * result + (exception?.stackTraceHashCodeSum() ?: 0)
            return result
        }

        override fun toString(): String =
            "HttpFailure(code=$code, message=$message, backendError=$backendError, exception=$exception)"
    }
}

private fun Exception?.isEquals(other: Exception?): Boolean =
    (this == null && other == null)
            || (this != null && other != null && Arrays.deepEquals(stackTrace, other.stackTrace))

private fun Exception.stackTraceHashCodeSum(): Int =
    stackTrace.sumOf(StackTraceElement::hashCode)

inline fun <T> networkRequest(block: () -> T): NetworkResponse<T> =
    try {
        Either.Right(block())
    } catch (exception: IOException) {
        Either.Left(NetworkFailure.NoConnection(exception))
    } catch (exception: HttpException) {
        val errorBody = exception.response()?.errorBody()
        Either.Left(NetworkFailure.HttpFailure(exception, backendError = errorBody?.let(::errorResponse)?.error))
    }

fun errorResponse(errorBody: ResponseBody): ErrorResponse? =
    try {
        Gson().fromJson(errorBody.string(), ErrorResponse::class.java)
    } catch (ex: JsonParseException) {
        null
    }