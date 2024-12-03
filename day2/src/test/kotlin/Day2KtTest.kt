package uk.co.brmartin.adventofcode2024.app

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class Day2KtTest {

    @Test
    fun solveTest() {
        val reader = """
            7 6 4 2 1
            1 2 7 8 9
            9 7 6 2 1
            1 3 2 4 5
            8 6 4 4 1
            1 3 6 7 9 10""".trimIndent().reader()

        solve(reader) shouldBe 2
    }
}
