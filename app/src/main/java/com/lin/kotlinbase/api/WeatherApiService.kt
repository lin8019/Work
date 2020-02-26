package com.lin.kotlinbase.api

import com.lin.kotlinbase.api.entity.ResponseEntity
import retrofit2.http.GET
import retrofit2.http.Query

enum class LOCATION(val locationName: String) {
    TAIPEI("臺北市"),
}

enum class ELEMENT {
    MinT,
}

interface WeatherApiService {
    @GET("F-C0032-001")
    suspend fun getAfter36hrWeather(@Query("Authorization") authorization: String,
                            @Query("locationName") locationName: String,
                            @Query("elementName") elementName: String): ResponseEntity?
}