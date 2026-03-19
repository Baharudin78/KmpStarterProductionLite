package com.rudy.kmpstarterproductionlite.util

sealed class AppException(override val message: String) : Exception(message) {
    data object Unauthorized : AppException("Session expired")
    data object NoInternet : AppException("No internet connection")
    data class Server(override val message: String) : AppException(message)
    data class Unknown(override val message: String) : AppException(message)
}
