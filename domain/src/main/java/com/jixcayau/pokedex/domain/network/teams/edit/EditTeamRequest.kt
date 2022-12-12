package com.jixcayau.pokedex.domain.network.teams.edit

import com.jixcayau.pokedex.domain.entities.Team

data class EditTeamRequest(
    val userId: String,
    val team: Team,
)