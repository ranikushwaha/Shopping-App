package com.example.weatherappkmm.model

import kotlinx.serialization.Serializable

@Serializable
data class WeatherResponse(
    val current_weather: CurrentWeather? = null
)

@Serializable
data class CurrentWeather(
    val temperature: Double? = null,
    val windspeed: Double? = null,
    val winddirection: Double? = null,
    val weathercode: Int? = null,
    val time: String? = null
)

