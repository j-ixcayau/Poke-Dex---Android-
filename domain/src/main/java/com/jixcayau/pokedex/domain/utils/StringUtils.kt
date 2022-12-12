package com.jixcayau.pokedex.domain.utils

import android.os.Build
import android.util.Base64

class StringUtils {
    fun encodeBase64(value: String): String {
        val credentialByte = value.toByteArray(Charsets.UTF_8)
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            java.util.Base64.getEncoder().encodeToString(credentialByte)
        } else {
            Base64.encodeToString(credentialByte, Base64.DEFAULT)
        }
    }

    fun decodeBase64(value: String): String {
        return String(Base64.decode(value, Base64.DEFAULT))
    }
}