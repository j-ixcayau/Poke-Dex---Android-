package com.jixcayau.pokedex.utils

class RoutesPath {
    companion object {
        const val Login = "authScreen"
        const val Register = "register"
        const val Dashboard = "dashboard"
        const val Regions = "regions"
        const val Teams = "teams"
        const val CreateTeam = "createTeam/{regionJson}"
        const val CreateTeamForm = "createTeamForm/{teamJson}"
        const val TeamDetail = "teamDetail/{teamJson}"

        const val CreateTeamToNavigate = "createTeam/"
        const val CreateTeamFormToNavigate = "createTeamForm/"
        const val TeamDetailToNavigate = "teamDetail/"
    }
}