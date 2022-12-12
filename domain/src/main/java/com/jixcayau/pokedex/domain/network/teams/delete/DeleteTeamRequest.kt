package com.jixcayau.pokedex.domain.network.teams.delete

data class DeleteTeamRequest(
    val userId: String,
    val teamId: String,
)