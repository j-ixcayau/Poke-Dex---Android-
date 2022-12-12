package com.jixcayau.pokedex.data.repositories.team

import com.google.firebase.database.ktx.getValue
import com.jixcayau.pokedex.data.utils.FirebaseUtils
import com.jixcayau.pokedex.domain.entities.Team
import com.jixcayau.pokedex.domain.network.teams.list.GetTeamsRequest
import com.jixcayau.pokedex.domain.network.teams.list.GetTeamsResponse
import com.jixcayau.pokedex.domain.repositories.teams.GetTeamsRepository


class GetTeamsRepositoryImpl : GetTeamsRepository {
    override fun getTeams(
        request: GetTeamsRequest, success: (response: GetTeamsResponse) -> Unit, failure: () -> Unit
    ) {
        val response =
            FirebaseUtils.getReference.child(FirebaseUtils.teamsCol).child(request.userId).get()

        response.addOnCompleteListener { task ->
            if (task.isSuccessful) {
                try {
                    val teams = ArrayList<Team>()

                    for (child in task.result.children) {
                        child.getValue<Team>()?.let {
                            teams.add(it)
                        }
                    }

                    success(
                        GetTeamsResponse(
                            teams = teams,
                        )
                    )
                    return@addOnCompleteListener
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }


            failure()
        }

        response.addOnFailureListener {
            it.printStackTrace()
            failure()
        }

        response.addOnCanceledListener {
            failure()
        }
    }
}