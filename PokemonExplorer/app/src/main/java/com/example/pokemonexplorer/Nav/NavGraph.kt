package com.example.pokemonexplorer.Nav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pokemonexplorer.UiScreens.DetailScreen
import com.example.pokemonexplorer.UiScreens.Home

@Composable
fun NavGraph(startDestination: String = "main") {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable("main") {
            Home(navController)
        }
//        composable("detail/{pokemonId}") { backStackEntry ->
//            val pokemonId = backStackEntry.arguments?.getString("pokemonId")?.toIntOrNull()
//            pokemonId?.let {
//                DetailScreen(it)
//            } ?: run {
//                // Handle the case where pokemonId is not a valid integer
//                // You can navigate back or show an error message here
//            }
//        }
    }
}
