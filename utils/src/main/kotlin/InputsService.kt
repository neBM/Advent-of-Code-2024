package uk.co.brmartin.adventofcode2024.utils

import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import java.lang.System.getenv

class InputsService(
    private val httpClient: OkHttpClient = OkHttpClient(),
    private val aocSession: String = getenv("AOC_SESSION") ?: error("AOC_SESSION not set"),
) {
    fun getInputsForDay(day: UInt) = getInputsRequestFor(day)
        .let(httpClient::newCall)
        .execute()
        .apply { if (!isSuccessful) error("Failed to get input for day $day: $message") }
        .body!!
        .charStream()

    private fun getInputsUrlFor(day: UInt) = HttpUrl.Builder()
        .scheme("https")
        .host(AOC_HOST)
        .addPathSegments("2024/day/$day/input")
        .build()

    private fun getInputsRequestFor(day: UInt) = Request.Builder()
        .url(getInputsUrlFor(day))
        .header("Cookie", "session=$aocSession")
        .build()
}
