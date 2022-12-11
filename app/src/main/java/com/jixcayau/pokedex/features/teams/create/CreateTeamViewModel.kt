package com.jixcayau.pokedex.features.teams.create

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.jixcayau.pokedex.data.repositories.pokemon.GetPokemonsRepository
import com.jixcayau.pokedex.domain.entities.Pokemon

class CreateTeamViewModel : ViewModel() {
    var pokemons by mutableStateOf<List<Pokemon>>(listOf())
    private val pokemonsSelected = mutableStateListOf<Int>()


    init {
        loadPokemons()
    }

    private fun loadPokemons() {
        if (pokemons.isNotEmpty()) return

        GetPokemonsRepository().getPokemons(
            {
                pokemons = it.results
            },
            {
                println("Error")
            },
        )
    }

    fun onPokemonTap(index: Int) {
        // If already contains just remove
        if (pokemonsSelected.contains(index)) {
            pokemonsSelected.remove(index)
        } else {
            // If is not selected avoid selection
            if (pokemonsSelected.size < 6) {
                pokemonsSelected.add(index)
            }
        }
    }

    fun isPokemonSelected(index: Int): Boolean {
        return pokemonsSelected.contains(index)
    }

    fun createTeam() {
        // Avoid creation when user don't have 3 to 6
        if (pokemonsSelected.size !in 3..6) {
            return
        }



    }
}