package com.jixcayau.pokedex.utils.auth

import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class FirebaseAuthManager {
    fun register(
        email: String,
        password: String,
        result: (Boolean) -> Unit,
    ) {
        val response = Firebase.auth.createUserWithEmailAndPassword(email.trim(), password.trim())

        response.addOnCompleteListener {
            result(response.isSuccessful)
        }

        response.addOnCanceledListener {
            result(false)
        }

        response.addOnFailureListener {
            it.printStackTrace()
            result(false)
        }
    }

    fun signIn(
        email: String,
        password: String,
        result: (Boolean) -> Unit,
    ) {
        val response = Firebase.auth.signInWithEmailAndPassword(email.trim(), password.trim())

        response.addOnCompleteListener {
            result(response.isSuccessful)
        }

        response.addOnCanceledListener {
            result(false)
        }

        response.addOnFailureListener {
            it.printStackTrace()
            result(false)
        }
    }
}