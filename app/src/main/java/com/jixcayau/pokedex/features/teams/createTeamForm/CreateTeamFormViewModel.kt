package com.jixcayau.pokedex.features.teams.createTeamForm

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.jixcayau.pokedex.data.repositories.team.CreateTeamRepositoryImpl
import com.jixcayau.pokedex.domain.entities.Team
import com.jixcayau.pokedex.domain.network.teams.create.CreateTeamRequest
import java.util.*

class CreateTeamFormViewModel : ViewModel() {

    var teamCreated by mutableStateOf(false)

    fun createTeam(
        team: Team,
        name: String,
        number: String,
        type: String,
    ) {
        val userId = Firebase.auth.currentUser?.uid ?: return

        team.id = UUID.randomUUID().toString()
        team.name = name.trim()
        team.number = number.trim()
        team.type = type.trim()

        CreateTeamRepositoryImpl().createTeam(
            request = CreateTeamRequest(
                userId = userId,
                team = team,
            ),
            success = {
                teamCreated = it.success
            },
            failure = {
                Log.d("teamCreated", "Team created")
            }
        )
    }
}