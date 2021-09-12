package com.example.lowescodingchallenge.ui.routing

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.lowescodingchallenge.R


sealed class Screen(val titleResId: Int) {
    object City: Screen(R.string.city)
    object Forecast: Screen(R.string.forecast)
    object ForecastDetail: Screen(R.string.forecast_details)
}

object LowesRouter {
    var currentScreen: MutableState<Screen> = mutableStateOf(
        Screen.City
    )

    private var previousScreen: MutableState<Screen> = mutableStateOf(
        Screen.City
    )

    fun navigateTo(destination: Screen) {
        previousScreen.value = currentScreen.value
        currentScreen.value = destination
    }

    fun goBack() {
        currentScreen.value = previousScreen.value
    }
}