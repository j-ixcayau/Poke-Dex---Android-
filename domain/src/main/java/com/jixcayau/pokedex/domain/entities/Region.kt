package com.jixcayau.pokedex.domain.entities

import com.google.firebase.database.IgnoreExtraProperties
import com.google.gson.Gson
import com.jixcayau.pokedex.domain.utils.StringUtils
import com.jixcayau.pokedex.domain.utils.idFromUrl
import java.io.Serializable

@IgnoreExtraProperties
data class Region(
    val name: String? = null,
    val url: String? = null,
) : Serializable {
    val id: Int
        get() = url?.idFromUrl() ?: 0
}


fun Region.toJson(): String {
    val json = Gson().toJson(this)
    return StringUtils().encodeBase64(json)
}

fun String.toRegion(): Region {
    val json = StringUtils().decodeBase64(this)
    return Gson().fromJson(json, Region::class.java)
}