package com.jixcayau.pokedex.domain.utils

fun String.idFromUrl(): Int {
    val components = this.split("/")
    return components[components.size - 2].toIntOrNull() ?: 0
}