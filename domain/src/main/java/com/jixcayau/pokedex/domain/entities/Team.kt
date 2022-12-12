package com.jixcayau.pokedex.domain.entities

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class Team(
    val id: String? = null,
    val name: String? = null,
    val number: String? = null,
    val type: String? = null,
    val pokemons: List<Pokemon>? = null,
    val region: Region? = null,
)