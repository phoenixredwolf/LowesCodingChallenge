package com.example.lowescodingchallenge.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lowescodingchallenge.BuildConfig.API_ID
import com.example.lowescodingchallenge.data.model.WeatherResponseDTO
import com.example.lowescodingchallenge.data.repo.DataRepository
import com.example.lowescodingchallenge.utility.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(repo: DataRepository) : ViewModel() {

    var city = ""
    val dataRepo = repo
    private val _weatherData = MutableLiveData<Resource<WeatherResponseDTO>>()
    private var getForecastJob: Job? = null
    val weather: LiveData<Resource<WeatherResponseDTO>> get() = _weatherData

    fun getForecast() {
        getForecastJob = viewModelScope.launch {
            dataRepo.getData(city, API_ID, "imperial").collect {
                _weatherData.value = it
            }
        }
    }
}


