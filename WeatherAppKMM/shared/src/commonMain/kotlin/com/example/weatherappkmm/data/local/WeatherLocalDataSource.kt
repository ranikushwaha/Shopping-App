package com.example.weatherappkmm.data.local

import com.example.weatherappkmm.cache.WeatherDb
import com.example.weatherappkmm.model.CurrentWeather

class WeatherLocalDataSource(private val db: WeatherDb) {

    private val queries = db.weatherDbQueries

    fun clearWeather() {
        queries.deleteAll()
    }
}
