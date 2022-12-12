package com.jixcayau.pokedex.domain.entities

import com.google.firebase.database.IgnoreExtraProperties
import com.jixcayau.pokedex.domain.utils.idFromUrl
import java.io.Serializable

@IgnoreExtraProperties
data class Pokemon(
    val name: String? = null,
    val url: String? = null,
) : Serializable {
    val id: Int
        get() = url?.idFromUrl() ?: 0
    val imageUrl: String
        get() = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$id.png"

}