package com.example.pokemonexplorer.UiScreens

import Pokemon
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.pokemonexplorer.Models.PokemonListViewModel

@Composable
fun Home(navController: NavController, viewModel: PokemonListViewModel = hiltViewModel()) {
    val pokemonList by viewModel.pokemonList

    LazyColumn {
        items(pokemonList) { pokemon ->
            PokemonListItem(pokemon, onClick = {
                navController.navigate("detail/${pokemon.name}")
            })
        }
    }
}


@Composable
fun PokemonListItem(pokemon: Pokemon, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(onClick = onClick),
        elevation = 4.dp
    ) {
        Text(text = pokemon.name, modifier = Modifier.padding(16.dp))
    }
}
