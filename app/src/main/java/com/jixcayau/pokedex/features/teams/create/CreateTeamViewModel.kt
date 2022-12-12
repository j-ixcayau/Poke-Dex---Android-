package com.jixcayau.pokedex.features.teams.create

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.jixcayau.pokedex.data.repositories.pokemon.GetPokemonsRepository
import com.jixcayau.pokedex.data.repositories.team.CreateTeamRepositoryImpl
import com.jixcayau.pokedex.domain.entities.Pokemon
import com.jixcayau.pokedex.domain.entities.Region
import com.jixcayau.pokedex.domain.entities.Team
import com.jixcayau.pokedex.domain.network.teams.create.CreateTeamRequest
import java.util.*
import kotlin.collections.ArrayList

class CreateTeamViewModel : ViewModel() {
    var pokemons by mutableStateOf<List<Pokemon>>(listOf())
    val pokemonsSelected = mutableStateListOf<Int>()

    var teamCreated by mutableStateOf(false)

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

    fun createTeam(region: Region) {
        // Avoid creation when user don't have 3 to 6
        if (pokemonsSelected.size !in 3..6) {
            return
        }

        val pokemonsToCreate = ArrayList<Pokemon>(listOf())

        for (index in pokemonsSelected) {
            pokemonsToCreate.add(pokemons[index])
        }

        val userId = Firebase.auth.currentUser?.uid ?: return

        CreateTeamRepositoryImpl().createTeam(
            request = CreateTeamRequest(
                userId = userId,
                team = Team(
                    id = UUID.randomUUID().toString(),
                    name = "",
                    number = "",
                    type = "",
                    pokemons = pokemonsToCreate,
                    region = region,
                ),
            ),
            success = {
                teamCreated = it.success
            },
            failure = {
                Log.d("teamCreated", "Team created")
            }
        )
    }
}