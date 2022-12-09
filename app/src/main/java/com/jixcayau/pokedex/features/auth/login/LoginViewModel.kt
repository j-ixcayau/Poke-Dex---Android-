package com.jixcayau.pokedex.features.auth.login

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.jixcayau.pokedex.data.repositories.region.GetRegionsRepository
import com.jixcayau.pokedex.domain.entities.Region

class LoginViewModel : ViewModel() {

    private var auth: FirebaseAuth = Firebase.auth

    var regions: List<Region> by mutableStateOf(listOf())


    fun loadRegions() {
        Log.d("Loading regions", "Loading regions")

        GetRegionsRepository().getRegions(
            {
                regions = it.results
            },
            {
                println("Error")
            }
        )
    }


    fun googleSignin() {
//        auth.sin
    }
}