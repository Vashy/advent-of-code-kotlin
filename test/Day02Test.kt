import Day02.part1
import Day02.part2
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.assertAll
import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertEquals

class Day02Test {
    private val sampleInput: List<String> = listOf(
                "forward 5",
                "down 5",
                "forward 8",
                "up 3",
                "down 8",
                "forward 2")

    @Nested
    inner class Part1 {
        @Test
        internal fun `simple cases`() {
            assertAll(
                { assertEquals(0, part1(listOf())) },
                { assertEquals(5, part1(listOf("forward 5"))) },
                { assertEquals(6, part1(listOf("down 6"))) },
                { assertEquals(0, part1(listOf("up 3", "down 3"))) },
            )
        }

        @Test
        internal fun `problem sample input`() {
            val input = sampleInput

            assertEquals(150, part1(input))
        }

        @Test
        internal fun `problem input`() {
            val input = readInput("Day02")

            assertEquals(1488669, part1(input))
        }
    }

    @Nested
    inner class Part2 {
        @Test
        internal fun `simple cases`() {
            assertAll(
                { assertEquals(0, part2(listOf())) },
                { assertEquals(5, part2(listOf("forward 5"))) },
                { assertEquals(0, part2(listOf("down 5"))) },
            )
        }

        @Test
        internal fun `problem sample input`() {
            assertEquals(900, part2(sampleInput))
        }

        @Test
        internal fun `problem input`() {
            val input = readInput("Day02")

            assertEquals(1176514794, part2(input))
        }
    }
}
