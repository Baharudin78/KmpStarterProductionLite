package com.rudy.kmpstarterproductionlite.util

import kotlinx.coroutines.CancellationException

suspend fun <T> safeApiCall(block: suspend () -> T): Result<T> {
    return try {
        Result.Success(block())
    } catch (e: CancellationException) {
        throw e
    } catch (e: Exception) {
        Result.Error(mapException(e))
    }
}

fun mapException(e: Exception): AppException {
    return when {
        e.message?.contains("401") == true -> AppException.Unauthorized
        e.message?.contains("Unable to resolve host") == true -> AppException.NoInternet
        e.message?.contains("timeout") == true -> AppException.NoInternet
        e.message?.contains("5") == true && e.message?.contains("00") == true ->
            AppException.Server(e.message ?: "Server error")
        else -> AppException.Unknown(e.message ?: "Unknown error")
    }
}
