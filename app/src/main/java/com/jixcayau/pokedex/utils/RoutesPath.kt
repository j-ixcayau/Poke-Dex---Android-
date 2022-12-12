package com.jixcayau.pokedex.utils

class RoutesPath {
    companion object {
        const val Login = "authScreen"
        const val Register = "register"
        const val Dashboard = "dashboard"
        const val Regions = "regions"
        const val Teams = "teams"
        const val TeamCreate = "teamCreate/{regionJson}"
        const val TeamCreateForm = "teamCreateForm/{teamJson}"
        const val TeamDetail = "teamDetail/{teamJson}"
        const val TeamEdit = "teamEdit/{teamJson}"

        const val TeamCreateToNavigate = "teamCreate/"
        const val TeamCreateFormToNavigate = "teamCreateForm/"
        const val TeamDetailToNavigate = "teamDetail/"
        const val TeamEditToNavigate = "teamEdit/"
    }
}