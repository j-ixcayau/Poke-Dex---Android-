package com.jixcayau.pokedex.features.auth.register

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.jixcayau.pokedex.utils.auth.FirebaseAuthManager

class RegisterViewModel : ViewModel() {
    private val manager = FirebaseAuthManager()

    var customLogged by mutableStateOf(false)

    fun register(email: String, password: String) {
        if (email.trim().isEmpty() || password.trim().isEmpty()) {
            return
        }

        manager.register(
            email = email,
            password = password,
            result = {
                customLogged = it
            }
        )
    }
}