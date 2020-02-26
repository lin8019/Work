package com.lin.kotlinbase.api.entity

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class ResponseEntity {
    @SerializedName("records")
    var records: RecordEntity? = null
}

class RecordEntity {
    @SerializedName("location")
    var location: List<LocationEntity>? = null
}

class LocationEntity {
    @SerializedName("weatherElement")
    var weatherElement: List<WeatherElementEntity>? = null
}

class WeatherElementEntity {
    @SerializedName("time")
    var time: List<TimeEntity>? = null
}

class TimeEntity : Serializable{
    @SerializedName("startTime")
    var startTime: String? = null

    @SerializedName("endTime")
    var endTime: String? = null

    @SerializedName("parameter")
    var parameter: ParameterEntity? = null

}

class ParameterEntity : Serializable {
    @SerializedName("parameterName")
    var parameterName: String? = null

    @SerializedName("parameterUnit")
    var parameterUnit: String? = null
}

