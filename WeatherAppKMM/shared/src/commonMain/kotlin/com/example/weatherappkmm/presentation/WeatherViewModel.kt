package com.example.weatherappkmm.presentation

import com.example.weatherappkmm.model.WeatherResponse
import com.example.weatherappkmm.repository.WeatherRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class WeatherViewModel(
    private val repository: WeatherRepository
) : CoroutineScope by MainScope() {

    private val _state = MutableStateFlow<WeatherState>(WeatherState.Loading)
    val state: StateFlow<WeatherState> = _state

    private val viewModelScope = CoroutineScope(Dispatchers.Default)
    fun loadWeather(lat: Double, lon: Double) {
        viewModelScope.launch {
            try {
                val weather = repository.getWeather(lat, lon)
                _state.value = WeatherState.Success(weather)
            } catch (e: Exception) {
                _state.value = WeatherState.Error(e.message ?: "Unknown error")
            }
        }
    }
}
