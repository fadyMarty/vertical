package com.verticalautomotive.android.common.util

import java.util.Locale

object FormatUtil {

    fun formatPhoneNumber(phoneNumber: String): String {
        return buildString {
            append('+')
            append(phoneNumber, 0, 1)
            append(" (")
            append(phoneNumber, 1, 4)
            append(") ")
            append(phoneNumber, 4, 7)
            append('-')
            append(phoneNumber, 7, 11)
        }
    }

    fun formatDuration(seconds: Int): String {
        val minutes = seconds / 60
        val seconds = seconds % 60

        return String.format(Locale.US, "%d:%02d", minutes, seconds)
    }
}