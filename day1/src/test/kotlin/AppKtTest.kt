
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import uk.co.brmartin.adventofcode2024.app.solve

class AppKtTest {

    @Test
    fun solveTest() {
        val reader = """
            3   4
            4   3
            2   5
            1   3
            3   9
            3   3""".trimIndent().reader()

        solve(reader) shouldBe 11
    }
}
