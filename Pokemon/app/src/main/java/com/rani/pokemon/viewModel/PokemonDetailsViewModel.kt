package com.rani.pokemon.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rani.pokemon.services.PokemonDetailsResponse
import com.rani.pokemon.services.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonDetailsViewModel : ViewModel() {
    private val _pokemonDetails = MutableLiveData<PokemonDetailsResponse>()
    val pokemonDetails: LiveData<PokemonDetailsResponse> get() = _pokemonDetails

    fun fetchPokemonDetails(id: Int) {
        RetrofitInstance.api.getPokemonDetails(id).enqueue(object : Callback<PokemonDetailsResponse> {
            override fun onResponse(
                call: Call<PokemonDetailsResponse>,
                response: Response<PokemonDetailsResponse>
            ) {
                if (response.isSuccessful) {
                    _pokemonDetails.value = response.body()
                    Log.d("response12345", response.body().toString())
                } else {
                    Log.d("response123456", response.body().toString())
                }
            }

            override fun onFailure(call: Call<PokemonDetailsResponse>, t: Throwable) {
                // Handle error
                Log.d("response1234", t.message.toString())
            }
        })
    }
}
