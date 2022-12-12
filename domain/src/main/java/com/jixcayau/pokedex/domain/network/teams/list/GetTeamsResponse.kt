package com.jixcayau.pokedex.domain.network.teams.list

import com.jixcayau.pokedex.domain.entities.Team

data class GetTeamsResponse(
    val teams: List<Team>,
)