package com.lin.kotlinbase.model

import com.lin.kotlinbase.api.*
import com.lin.kotlinbase.api.entity.ResponseEntity
import java.lang.Exception

class Repository {

    enum class SOURCETYPE {
        REMOTE,
        LOCAL
    }

    private val responseHandler: ResponseHandler = ResponseHandler()

    suspend fun getWeatherData(
        auth: String,
        sourceType: SOURCETYPE,
        location: LOCATION,
        params: ELEMENT
    ): Resource<ResponseEntity?> {
        return when (sourceType) {
            SOURCETYPE.REMOTE ->
                try {
                    responseHandler.handleSuccess(ApiManager.getApi(WeatherApiService::class.java).getAfter36hrWeather(
                        auth,
                        location.locationName,
                        params.name
                    ))
                } catch (e: Exception) {
                    return responseHandler.handleException(e)
                }
            SOURCETYPE.LOCAL -> responseHandler.handleException(Exception("no local data"))
        }
    }
}

