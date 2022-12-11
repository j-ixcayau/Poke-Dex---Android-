package com.jixcayau.pokedex.domain.entities

import com.jixcayau.pokedex.domain.utils.idFromUrl
import java.io.Serializable

data class Region(
    val name: String,
    val url: String,
) : Serializable {
    val id: Int
        get() = url.idFromUrl()
}