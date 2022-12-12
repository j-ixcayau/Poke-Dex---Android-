package com.jixcayau.pokedex.data.repositories.team

import com.jixcayau.pokedex.data.utils.FirebaseUtils
import com.jixcayau.pokedex.domain.network.teams.delete.DeleteTeamRequest
import com.jixcayau.pokedex.domain.network.teams.delete.DeleteTeamResponse
import com.jixcayau.pokedex.domain.repositories.teams.DeleteTeamRepository

class DeleteTeamRepositoryImpl : DeleteTeamRepository {
    override fun deleteTeam(
        request: DeleteTeamRequest,
        success: (response: DeleteTeamResponse) -> Unit,
        failure: () -> Unit
    ) {
        val response =
            FirebaseUtils.getReference.child(FirebaseUtils.teamsCol).child(request.userId)
                .child(request.teamId)
                .removeValue()

        response.addOnCompleteListener {
            success(
                DeleteTeamResponse(
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