package com.example.weatherappkmm.repository

import com.example.weatherappkmm.model.WeatherResponse

interface WeatherRepository {
    suspend fun getWeather(lat: Double, lon: Double): WeatherResponse
}
