package com.jixcayau.pokedex.domain.repositories.pokemon

import com.jixcayau.pokedex.domain.network.pokemon.GetPokemonsResponse

interface GetPokemonsDataSource {
    fun getPokemons(success: (response: GetPokemonsResponse) -> Unit, failure: () -> Unit)
}