package com.example.bvgnativ.utils
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

fun getMinutesUntil(plannedTime: String?): Long? {
    if (plannedTime == null) return null
    return try {
        // ISO 8601 format with timezone: "2025-11-11T21:45:00+02:00"
        val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX", Locale.getDefault())
        val plannedDate: Date = sdf.parse(plannedTime) ?: return null
        val now = Date()
        val diffMillis = plannedDate.time - now.time
        TimeUnit.MILLISECONDS.toMinutes(diffMillis)
    } catch (_: Exception) {
        null
    }
}

