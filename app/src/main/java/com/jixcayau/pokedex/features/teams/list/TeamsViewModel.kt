package com.jixcayau.pokedex.features.teams.list

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.jixcayau.pokedex.data.repositories.team.GetTeamsRepositoryImpl
import com.jixcayau.pokedex.domain.entities.Team
import com.jixcayau.pokedex.domain.network.teams.list.GetTeamsRequest

class TeamsViewModel : ViewModel() {
    var teams by mutableStateOf<List<Team>>(listOf())

    init {
        getTeams()
    }

    private fun getTeams() {
        val userId = Firebase.auth.currentUser?.uid ?: return

        GetTeamsRepositoryImpl().getTeams(
            request = GetTeamsRequest(
                userId = userId,
            ),
            success = {
                teams = it.teams
            },
            failure = {
                Log.d("teamCreated", "Team created")
            }
        )
    }
}