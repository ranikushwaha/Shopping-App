package com.example.pokemonexplorer.Data

import PokemonDetail
import PokemonResponse

class PokemonRepository(private val api: PokemonApi) {
    suspend fun getPokemonList(limit: Int, offset: Int): PokemonResponse {
        return api.getPokemonList(limit, offset)
    }

    suspend fun getPokemonDetail(id: Int): PokemonDetail {
        return api.getPokemonDetail(id)
    }
}
