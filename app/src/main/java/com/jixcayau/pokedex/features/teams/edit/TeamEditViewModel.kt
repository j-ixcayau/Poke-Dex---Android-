package com.jixcayau.pokedex.features.teams.edit

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.jixcayau.pokedex.data.repositories.team.UpdateTeamRepositoryImpl
import com.jixcayau.pokedex.domain.entities.Team
import com.jixcayau.pokedex.domain.network.teams.edit.EditTeamRequest

class TeamEditViewModel : ViewModel() {
    private val updateRepository = UpdateTeamRepositoryImpl()

    var teamUpdated by mutableStateOf(false)


    fun updateTeam(team: Team, name: String, number: String, type: String) {
        val userId = Firebase.auth.currentUser?.uid ?: return

        team.name = name.trim()
        team.number = number.trim()
        team.type = type.trim()

        updateRepository.updateTeam(
            request = EditTeamRequest(
                userId = userId,
                team = team,
            ),
            success = {
                teamUpdated = it.success
            },
            failure = {
                Log.d("teamCreated", "Team created")
            }
        )
    }
}