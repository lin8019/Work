package com.lin.kotlinbase.api

import com.lin.kotlinbase.api.Status.*

enum class Status {
    SUCCESS,
    ERROR
}

data class Resource<out T>(val status: Status, val data: T?, val message: String?) {
    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(SUCCESS, data, null)
        }

        fun <T> error(msg: String, data: T?): Resource<T> {
            return Resource(ERROR, data, msg)
        }
    }
}