package com.jixcayau.pokedex.domain.network.teams.create

import com.jixcayau.pokedex.domain.entities.Team

data class CreateTeamRequest(
    val userId: String,
    val team: Team,
)