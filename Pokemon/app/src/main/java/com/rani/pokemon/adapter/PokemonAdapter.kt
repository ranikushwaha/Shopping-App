package com.rani.pokemon.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rani.pokemon.PokemonDetails
import com.rani.pokemon.R
import com.rani.pokemon.services.Pokemon
import android.content.Context
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController


class PokemonAdapter(private val pokemonList: List<Pokemon>,
                     private val navController: NavController
) : RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {

    class PokemonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val pokemonName: TextView = itemView.findViewById(R.id.pokemon_name)
        // You can also add an ImageView if you have Pokémon images
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_item, parent, false)
        return PokemonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val pokemon = pokemonList[position]
        holder.pokemonName.text = pokemon.name
        // Bind other data like image if available

        holder.itemView.setOnClickListener {
            val position = pokemon.url
            val bundle = Bundle().apply {
                putString("pokemonPosition", position)
            }
            navController.navigate(R.id.action_PokemonList_to_PokemonDetails, bundle)
        }
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }
}
