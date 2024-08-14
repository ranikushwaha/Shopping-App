package com.rani.pokemon.services

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApiService {
    @GET("pokemon")
    fun getPokemonList(@Query("offset") offset: Int, @Query("limit") limit: Int): Call<PokemonResponse>

    @GET("pokemon/{id}")
    fun getPokemonDetails(@Path("id") id: Int): Call<PokemonDetailsResponse>
}
