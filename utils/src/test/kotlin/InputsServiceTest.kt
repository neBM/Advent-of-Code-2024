package uk.co.brmartin.adventofcode2024.utils

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import okhttp3.OkHttpClient
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS
import java.util.UUID.randomUUID

@TestInstance(PER_CLASS)
class InputsServiceTest {

    private lateinit var underTest: InputsService
    private lateinit var httpClient: OkHttpClient

    @BeforeEach
    fun setUp() {
        httpClient = mockk()
        underTest = InputsService(httpClient, "${randomUUID()}")
    }

    @Test
    fun shouldGetInputsForDay() {
        every { httpClient.newCall(any()).execute() } returns mockk {
            every { isSuccessful } returns true
            every { body } returns mockk {
                every { charStream() } returns "1 2 3 4 5".reader()
            }
        }

        underTest.getInputsForDay(1u).readText() shouldBe "1 2 3 4 5"
    }

    @Test
    fun shouldThrowErrorIfRequestFails() {
        every { httpClient.newCall(any()).execute() } returns mockk {
            every { isSuccessful } returns false
            every { message } returns "Some message"
        }

        val exception = shouldThrow<IllegalStateException> {
            underTest.getInputsForDay(1u)
        }

        exception.message shouldBe "Failed to get input for day 1: Some message"
    }
}
