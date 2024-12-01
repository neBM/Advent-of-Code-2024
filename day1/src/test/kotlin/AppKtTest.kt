
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import uk.co.brmartin.adventofcode2024.app.solve

class AppKtTest {

    @Test
    fun solveTest() {
        val reader = "3   4\n4   3\n2   5\n1   3\n3   9\n3   3".reader()

        solve(reader) shouldBe 11
    }
}
