package com.jixcayau.pokedex.features.auth.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.jixcayau.pokedex.utils.auth.FirebaseAuthManager

class LoginViewModel : ViewModel() {
    private val manager = FirebaseAuthManager()

    var customLogged by mutableStateOf(false)

    fun signIn(email: String, password: String) {
        if(email.trim().isEmpty() || password.trim().isEmpty()){
            return
        }

        manager.signIn(
            email = email,
            password = password,
            result = {
                customLogged = it
            }
        )
    }
}