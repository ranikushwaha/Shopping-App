package com.example.weatherappkmm.network

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.serialization.json.Json
import com.example.weatherappkmm.model.WeatherResponse
import io.ktor.client.statement.bodyAsText

class ApiClient {
    private val client = provideHttpClient()
    private val json = Json { ignoreUnknownKeys = true }

    suspend fun fetchWeather(lat: Double, lon: Double): WeatherResponse {
        val url = "https://api.open-meteo.com/v1/forecast?latitude=$lat&longitude=$lon&hourly=temperature_2m&current_weather=true"
        val httpResponse = client.get(url).bodyAsText()
        return json.decodeFromString(WeatherResponse.serializer(), httpResponse)
    }
}