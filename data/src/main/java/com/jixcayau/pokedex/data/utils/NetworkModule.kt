package com.jixcayau.pokedex.data.utils

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class NetworkModule {
    fun provideApiMethods(): ApiMethods {
        return Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(provideHttpClient())
            .build()
            .create(ApiMethods::class.java)
    }


    private fun provideHttpClient(): OkHttpClient {

        val logInterceptor = HttpLoggingInterceptor()
        logInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val httpClient = OkHttpClient().newBuilder()
        httpClient.readTimeout(1000, TimeUnit.SECONDS)
        httpClient.connectTimeout(1000, TimeUnit.SECONDS)
        httpClient.writeTimeout(1000, TimeUnit.SECONDS)
        httpClient.retryOnConnectionFailure(false)


        val interceptor = Interceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("Connection", "close")
                .method(chain.request().method, chain.request().body)
                .build()
            chain.proceed(request)
        }

        httpClient.addInterceptor(logInterceptor)
        httpClient.networkInterceptors().add(interceptor)

        return httpClient.build()
    }

    companion object {
        const val BaseUrl = "https://pokeapi.co/api/v2/"
    }
}