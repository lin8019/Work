package com.lin.kotlinbase.viewmodel

import androidx.lifecycle.*
import com.lin.kotlinbase.api.*
import com.lin.kotlinbase.api.entity.TimeEntity
import com.lin.kotlinbase.model.Repository
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val repository = Repository()

    val data: MutableLiveData<List<TimeEntity>> = MutableLiveData()
    val errorMessage: MutableLiveData<String> = MutableLiveData()

    fun getWeatherData(auth: String, sourceType: Repository.SOURCETYPE, location: LOCATION, params: ELEMENT) {
        viewModelScope.launch {
            val response = repository.getWeatherData(auth, sourceType, location, params)
            when(response.status) {
                Status.SUCCESS -> data.value = response.data?.records?.location?.get(0)?.weatherElement?.get(0)?.time
                Status.ERROR -> errorMessage.value = response.message
            }
        }
    }
}