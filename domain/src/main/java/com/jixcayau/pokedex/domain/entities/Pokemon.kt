package com.jixcayau.pokedex.domain.entities

import com.jixcayau.pokedex.domain.utils.idFromUrl
import java.io.Serializable

data class Pokemon(
    val name: String,
    val url: String,
) : Serializable {
    val id: Int
        get() = url.idFromUrl()
    val imageUrl: String
        get() = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$id.png"

}