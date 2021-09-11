package com.example.lowescodingchallenge.data.remote

import com.example.lowescodingchallenge.BuildConfig.API_ID
import com.example.lowescodingchallenge.data.model.WeatherResponseDTO
import com.example.lowescodingchallenge.di.NetworkModule
import retrofit2.Response

object WeatherManager {

    private val service: WeatherService
    private val retrofit = NetworkModule.provideRetrofit()

    init {
        service = retrofit.create(WeatherService::class.java)
    }

    suspend fun getData(
        city: String = "",
        appid: String = API_ID,
        units: String = "imperial"
    ) : Response<WeatherResponseDTO> {
        return service.getData(city, appid, units)
    }
}