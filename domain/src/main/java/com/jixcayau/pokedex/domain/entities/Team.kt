package com.jixcayau.pokedex.domain.entities

import com.google.firebase.database.IgnoreExtraProperties
import com.google.gson.Gson
import com.jixcayau.pokedex.domain.utils.StringUtils

@IgnoreExtraProperties
data class Team(
    var id: String? = null,
    var name: String? = null,
    var number: String? = null,
    var type: String? = null,
    val pokemons: List<Pokemon>? = null,
    val region: Region? = null,
)

fun Team.toJson(): String {
    val json = Gson().toJson(this)
    return StringUtils().encodeBase64(json)
}

fun String.toTeam(): Team {
    val json = StringUtils().decodeBase64(this)
    return Gson().fromJson(json, Team::class.java)
}