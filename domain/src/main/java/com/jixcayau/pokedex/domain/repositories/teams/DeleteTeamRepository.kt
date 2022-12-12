package com.jixcayau.pokedex.domain.repositories.teams

import com.jixcayau.pokedex.domain.network.teams.delete.DeleteTeamRequest
import com.jixcayau.pokedex.domain.network.teams.delete.DeleteTeamResponse

interface DeleteTeamRepository {
    fun deleteTeam(
        request: DeleteTeamRequest,
        success: (response: DeleteTeamResponse) -> Unit,
        failure: () -> Unit,
    )
}