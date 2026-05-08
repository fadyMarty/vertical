package com.verticalautomotive.android.common.util

import java.util.Locale

object FormatUtil {

    fun formatPhoneNumber(phoneNumber: String): String {
        return "+${phoneNumber.first()} (${phoneNumber.substring(1, 4)}) ${phoneNumber.substring(4, 7)}-${phoneNumber.substring(7, 11)}"
    }

    fun formatDuration(seconds: Int): String {
        val minutes = seconds / 60
        val seconds = seconds % 60

        return String.format(Locale.US, "%d:%02d", minutes, seconds)
    }
}