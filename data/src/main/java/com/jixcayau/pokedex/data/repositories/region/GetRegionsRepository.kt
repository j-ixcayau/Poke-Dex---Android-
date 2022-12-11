package com.jixcayau.pokedex.data.repositories.region

import com.jixcayau.pokedex.data.utils.NetworkModule
import com.jixcayau.pokedex.domain.network.region.GetRegionsResponse
import com.jixcayau.pokedex.domain.repositories.region.GetRegionsDataSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetRegionsRepository : GetRegionsDataSource {
    override fun getRegions(
        success: (response: GetRegionsResponse) -> Unit,
        failure: () -> Unit,
    ) {
        val methods = NetworkModule().provideApiMethods()

        methods.getRegions()
            .enqueue(
                object : Callback<GetRegionsResponse> {

                    override fun onResponse(
                        call: Call<GetRegionsResponse>,
                        response: Response<GetRegionsResponse>
                    ) {
                        if (response.isSuccessful && response.code() == 200) {
                            success(response.body()!!)
                        } else {
                            failure()
                        }
                    }

                    override fun onFailure(call: Call<GetRegionsResponse>, t: Throwable) {
                        failure()
                    }
                },
            )
    }
}