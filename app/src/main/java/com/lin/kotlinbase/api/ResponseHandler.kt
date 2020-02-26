package com.lin.kotlinbase.api

open class ResponseHandler {
    fun <T> handleSuccess(data: T): Resource<T> {
        return Resource.success(data)
    }

    fun <T> handleException(e: Exception): Resource<T> {
        return Resource.error(e.message ?: "no message", null)
    }
}
