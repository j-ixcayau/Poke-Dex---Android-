package com.jixcayau.pokedex.domain.repositories.teams

import com.jixcayau.pokedex.domain.network.teams.create.CreateTeamRequest
import com.jixcayau.pokedex.domain.network.teams.create.CreateTeamResponse

interface CreateTeamRepository {
    fun createTeam(
        request: CreateTeamRequest,
        success: (response: CreateTeamResponse) -> Unit,
        failure: () -> Unit,
    )
}