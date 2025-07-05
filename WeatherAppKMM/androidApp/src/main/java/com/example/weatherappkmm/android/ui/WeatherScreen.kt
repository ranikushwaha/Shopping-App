package com.example.weatherappkmm.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherappkmm.android.R
import com.example.weatherappkmm.presentation.WeatherState
import com.example.weatherappkmm.presentation.WeatherViewModel

@Composable
fun WeatherScreen(viewModel: WeatherViewModel) {
    val state by viewModel.state.collectAsState()
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFE3F2FD) // Light blue background
    ) {
        when (val currentState = state) {
            is WeatherState.Loading -> Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator(color = Color(0xFF2196F3))
            }

            is WeatherState.Error -> Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("Error: ${currentState.message}", color = Color.Red, fontWeight = FontWeight.Bold)
            }

            is WeatherState.Success -> {
                val weather = currentState.data.current_weather

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    // Greeting
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            "Hello, User 🌤️",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF0D47A1)
                        )
//                        Row(verticalAlignment = Alignment.CenterVertically) {
//                            Icon(Icons.Default.LocationOn, contentDescription = "Location", tint = Color(0xFF1976D2))
//                            Text("Gondia", fontWeight = FontWeight.Medium)
//                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    // Current Weather Card
                    Card(
                        shape = RoundedCornerShape(20.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFF2196F3)),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier.padding(30.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column {
                                Text(
                                    "${weather?.temperature ?: "--"}°C",
                                    fontSize = 42.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                                Text(
                                    "Updated At: ${weather?.time ?: "--"}",
                                    color = Color.White.copy(alpha = 0.9f),
                                    fontSize = 12.sp
                                )
                            }

                            Icon(
                                painter = painterResource(id = R.drawable.ic_cloud_sun_rain),
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(64.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    Text("Hourly Forecast", fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
                    Spacer(modifier = Modifier.height(10.dp))

                    LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                        items(listOf("12:00" to 32.0, "13:00" to 33.5, "14:00" to 34.2)) { (time, temp) ->
                            Card(
                                shape = RoundedCornerShape(16.dp),
                                colors = CardDefaults.cardColors(containerColor = Color.White),
                                modifier = Modifier.size(width = 100.dp, height = 140.dp),
                                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                            ) {
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center,
                                    modifier = Modifier.padding(10.dp)
                                ) {
                                    Text(time, fontWeight = FontWeight.Medium)
                                    Spacer(Modifier.height(6.dp))
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_moon_cloud),
                                        contentDescription = null,
                                        tint = Color(0xFF1E88E5),
                                        modifier = Modifier.size(32.dp)
                                    )
                                    Spacer(Modifier.height(6.dp))
                                    Text("$temp°C", fontWeight = FontWeight.Bold)
                                    Text("Cloudy", fontSize = 11.sp, color = Color.Gray)
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    Text("Today's Highlights", fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
                    Spacer(modifier = Modifier.height(10.dp))

                    Column {
                        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                            WeatherParam("Wind", "${weather?.windspeed ?: "--"} km/h", R.drawable.ic_wind)
                            WeatherParam("Humidity", "29%", R.drawable.ic_drop)
                            WeatherParam("UV Index", "High", R.drawable.ic_sun)
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                            WeatherParam("Air Quality", "Moderate", R.drawable.ic_mask)
                            WeatherParam("Pressure", "1001 MB", R.drawable.ic_pressure)
                            WeatherParam("Visibility", "10 km", R.drawable.ic_visibility)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun WeatherParam(title: String, value: String, iconId: Int) {
    Card(
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(1.dp, Color(0xFFBBDEFB)),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier
            .padding(4.dp)
            .width(100.dp)
            .height(100.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(8.dp)
        ) {
            Icon(
                painter = painterResource(id = iconId),
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                tint = Color(0xFF1565C0)
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(value, fontWeight = FontWeight.Bold, fontSize = 14.sp)
            Text(title, fontSize = 11.sp, color = Color.Gray)
        }
    }
}

