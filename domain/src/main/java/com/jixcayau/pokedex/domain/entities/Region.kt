package com.jixcayau.pokedex.domain.entities

import java.io.Serializable

data class Region(
    val name: String,
    val url: String,
) : Serializable {
    val id: Int
        get() {
            val components = url.split("/")
            return components[components.size - 2].toIntOrNull() ?: 0
        }
}