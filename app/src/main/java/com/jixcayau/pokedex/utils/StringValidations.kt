package com.jixcayau.pokedex.utils

import android.util.Patterns

class StringValidations {
    companion object {
        fun validText(value: String): Boolean {
            return value.trim().isNotEmpty()
        }

        fun validEmail(value: String): Boolean {
            return Patterns.EMAIL_ADDRESS.matcher(value.trim()).matches()
        }


        fun validPassword(value: String): Boolean {
            if (value.length < 8) return false
            if (value.firstOrNull { it.isDigit() } == null) return false
            if (value.filter { it.isLetter() }
                    .firstOrNull { it.isUpperCase() } == null) return false
            if (value.filter { it.isLetter() }
                    .firstOrNull { it.isLowerCase() } == null) return false
            if (value.firstOrNull { !it.isLetterOrDigit() } == null) return false

            return true
        }
    }
}