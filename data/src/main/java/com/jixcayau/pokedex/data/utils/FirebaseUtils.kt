package com.jixcayau.pokedex.data.utils

import com.google.firebase.database.FirebaseDatabase

class FirebaseUtils {
    companion object {
        val getReference = FirebaseDatabase.getInstance().reference
        const val teamsCol = "teams"
    }
}