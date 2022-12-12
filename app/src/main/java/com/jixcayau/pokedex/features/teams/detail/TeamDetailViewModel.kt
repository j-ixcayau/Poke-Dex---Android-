package com.jixcayau.pokedex.features.teams.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.jixcayau.pokedex.data.repositories.team.DeleteTeamRepositoryImpl
import com.jixcayau.pokedex.domain.entities.Team
import com.jixcayau.pokedex.domain.network.teams.delete.DeleteTeamRequest

class TeamDetailViewModel : ViewModel() {
    private val deleteRepository = DeleteTeamRepositoryImpl()
    var teamDeleted by mutableStateOf(false)


    fun deleteTeam(team: Team) {
        val userId = Firebase.auth.currentUser?.uid ?: return

        deleteRepository.deleteTeam(
            DeleteTeamRequest(
                userId = userId,
                teamId = team.id ?: "",
            ),
            success = {
                teamDeleted = it.success
            },
            failure = {

            }
        )
    }
}