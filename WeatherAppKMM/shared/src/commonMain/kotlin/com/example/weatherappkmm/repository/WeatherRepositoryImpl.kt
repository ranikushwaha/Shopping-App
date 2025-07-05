package com.example.weatherappkmm.repository

import com.example.weatherappkmm.model.WeatherResponse
import com.example.weatherappkmm.network.ApiClient
import com.example.weatherappkmm.cache.WeatherDb
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.datetime.Clock
import kotlinx.serialization.json.Json

class WeatherRepositoryImpl(
    private val apiClient: ApiClient,
    private val database: WeatherDb
) : WeatherRepository {

    private val weatherQueries = database.weatherDbQueries // ✅ fixed name
    private val json = Json { ignoreUnknownKeys = true }

    override suspend fun getWeather(lat: Double, lon: Double): WeatherResponse {
        return try {
            val result = apiClient.fetchWeather(lat, lon)
            val serialized = json.encodeToString(WeatherResponse.serializer(), result)

            withContext(Dispatchers.Default) {
                weatherQueries.transaction {
                    weatherQueries.deleteAll()
                    weatherQueries.insert(
                        timestamp = Clock.System.now().toEpochMilliseconds(),
                        data_ = serialized
                    )
                }
            }

            result
        } catch (e: Exception) {
            val cached = weatherQueries.selectAll().executeAsOneOrNull()
            if (cached != null) {
                json.decodeFromString(WeatherResponse.serializer(), cached.data_)
            } else {
                throw e
            }
        }
    }
}
