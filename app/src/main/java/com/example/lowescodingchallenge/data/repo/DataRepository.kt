package com.example.lowescodingchallenge.data.repo

import com.example.lowescodingchallenge.BuildConfig.API_ID
import com.example.lowescodingchallenge.data.remote.WeatherManager
import com.example.lowescodingchallenge.utility.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class DataRepository {

    suspend fun getData(
        city: String,
        appid: String = API_ID,
        units: String = "imperial"
    ) = flow {
        emit(Resource.Loading)
        val response = WeatherManager.getData()
        val state = if (response.isSuccessful) {
            response.body()?.let {
                Resource.Success(it)
            } ?: Resource.Error("No data found")
        } else Resource.Error("Error fetching data")
        emit(state)
    }
}