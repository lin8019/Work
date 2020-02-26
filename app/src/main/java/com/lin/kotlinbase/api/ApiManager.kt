package com.lin.kotlinbase.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApiManager private constructor() {

    private val retrofit: Retrofit
    private val okHttpClient = OkHttpClient()

    init {
        retrofit = Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }


    companion object {
        private const val URL = "http://opendata.cwb.gov.tw/api/v1/rest/datastore/"

        private var manager : ApiManager = ApiManager()

        fun <T> getApi(serviceClass: Class<T>): T {
            return manager.retrofit.create(serviceClass)
        }
    }


}