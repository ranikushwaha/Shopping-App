package com.example.weatherappkmm.presentation

import com.example.weatherappkmm.model.WeatherResponse

sealed class WeatherState {
    object Loading : WeatherState()
    data class Success(val data: WeatherResponse) : WeatherState()
    data class Error(val message: String) : WeatherState()
}
