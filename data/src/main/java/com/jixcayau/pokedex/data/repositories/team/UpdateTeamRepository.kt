package com.jixcayau.pokedex.data.repositories.team

import com.jixcayau.pokedex.data.utils.FirebaseUtils
import com.jixcayau.pokedex.domain.network.teams.create.CreateTeamRequest
import com.jixcayau.pokedex.domain.network.teams.create.CreateTeamResponse
import com.jixcayau.pokedex.domain.network.teams.edit.EditTeamRequest
import com.jixcayau.pokedex.domain.network.teams.edit.EditTeamResponse
import com.jixcayau.pokedex.domain.repositories.teams.CreateTeamRepository
import com.jixcayau.pokedex.domain.repositories.teams.UpdateTeamRepository

class UpdateTeamRepositoryImpl : UpdateTeamRepository {
    override fun updateTeam(
        request: EditTeamRequest,
        success: (response: EditTeamResponse) -> Unit,
        failure: () -> Unit
    ) {
        val response =
            FirebaseUtils.getReference.child(FirebaseUtils.teamsCol).child(request.userId)
                .child(request.team.id!!)
                .setValue(request.team)

        response.addOnCompleteListener {
            success(
                EditTeamResponse(
                    success = response.isSuccessful,
                )
            )
        }

        response.addOnCanceledListener {
            failure()
        }

        response.addOnFailureListener {
            it.printStackTrace()
            failure()
        }
    }
}