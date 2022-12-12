package com.jixcayau.pokedex.utils

class RoutesPath {
    companion object {
        const val Login = "authScreen"
        const val Register = "register"
        const val Dashboard = "dashboard"
        const val Regions = "regions"
        const val Teams = "teams"
        const val CreateTeam = "createTeam/{regionJson}"

        const val CreateTeamToNavigate = "createTeam/"
    }
}