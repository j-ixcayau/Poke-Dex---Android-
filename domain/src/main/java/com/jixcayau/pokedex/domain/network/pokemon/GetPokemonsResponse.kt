package com.jixcayau.pokedex.domain.network.pokemon

import com.jixcayau.pokedex.domain.entities.Pokemon

data class GetPokemonsResponse(
    val results: List<Pokemon>
)