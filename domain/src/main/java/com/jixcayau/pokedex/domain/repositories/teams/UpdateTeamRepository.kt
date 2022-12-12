package com.jixcayau.pokedex.domain.repositories.teams

import com.jixcayau.pokedex.domain.network.teams.edit.EditTeamRequest
import com.jixcayau.pokedex.domain.network.teams.edit.EditTeamResponse

interface UpdateTeamRepository {
    fun updateTeam(
        request: EditTeamRequest,
        success: (response: EditTeamResponse) -> Unit,
        failure: () -> Unit,
    )
}