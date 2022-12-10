package com.jixcayau.pokedex.utils

fun String.toCapitalize(): String {
    return this.substring(0, 1).uppercase() + this.substring(1).lowercase()
}