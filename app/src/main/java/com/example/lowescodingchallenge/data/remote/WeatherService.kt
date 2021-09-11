package com.example.lowescodingchallenge.data.remote

import com.example.lowescodingchallenge.BuildConfig
import com.example.lowescodingchallenge.data.model.WeatherResponseDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET("forecast")
    suspend fun getData(
        @Query("q") city: String,
        @Query("appid") apiKey: String = BuildConfig.API_ID,
        @Query("units") units: String = "imperial"
    ) : Response<WeatherResponseDTO>
}