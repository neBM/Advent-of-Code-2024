package uk.co.brmartin.adventofcode2024.utils

import okhttp3.OkHttpClient
import okhttp3.Request.Builder

object InputSupplier {
    private val httpClient = OkHttpClient()

    fun getInputForDay(day: Int) = Builder()
        .url("https://adventofcode.com/2024/day/$day/input")
        .header("Cookie", "session=${System.getenv("AOC_SESSION") ?: error("AOC_SESSION not set")}")
        .build()
        .let(httpClient::newCall)
        .execute()
        .also { if (!it.isSuccessful) error("Failed to get input for day $day: $it") }
        .body!!
        .charStream()
}
