package com.jixcayau.pokedex.data.utils

import com.jixcayau.pokedex.domain.network.pokemon.GetPokemonsResponse
import com.jixcayau.pokedex.domain.network.region.GetRegionsResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiMethods {
    @GET("region")
    fun getRegions(): Call<GetRegionsResponse>

    @GET("pokemon?limit=2000")
    fun getPokemons(): Call<GetPokemonsResponse>
}