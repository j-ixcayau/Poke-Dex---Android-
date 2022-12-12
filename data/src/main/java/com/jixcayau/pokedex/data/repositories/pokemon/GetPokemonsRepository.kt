package com.jixcayau.pokedex.data.repositories.pokemon

import com.jixcayau.pokedex.data.utils.NetworkModule
import com.jixcayau.pokedex.domain.network.pokemon.GetPokemonsResponse
import com.jixcayau.pokedex.domain.repositories.pokemon.GetPokemonsDataRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetPokemonsRepositoryImpl : GetPokemonsDataRepository {
    override fun getPokemons(
        success: (response: GetPokemonsResponse) -> Unit,
        failure: () -> Unit,
    ) {
        val methods = NetworkModule().provideApiMethods()

        methods.getPokemons().enqueue(
            object : Callback<GetPokemonsResponse> {

                override fun onResponse(
                    call: Call<GetPokemonsResponse>, response: Response<GetPokemonsResponse>
                ) {
                    if (response.isSuccessful && response.code() == 200) {
                        success(response.body()!!)
                    } else {
                        failure()
                    }
                }

                override fun onFailure(call: Call<GetPokemonsResponse>, t: Throwable) {
                    failure()
                }
            },
        )
    }
}