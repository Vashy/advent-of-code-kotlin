import Day01.part1
import Day01.part2
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.assertAll
import java.io.File
import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertEquals

class Day01Test {
    @Nested
    inner class Part1 {
        @Test
        internal fun `simple cases`() {
            assertAll(
                { assertEquals(0, part1(listOf())) },
                { assertEquals(0, part1(listOf("1"))) },
                { assertEquals(1, part1(listOf("1", "2"))) },
                { assertEquals(2, part1(listOf("1", "2", "3"))) },
                { assertEquals(4, part1(listOf("1", "2", "3", "4", "5"))) }
            )
        }

        @Test
        internal fun `problem sample input`() {
            val input = listOf("199", "200", "208", "210", "200", "207", "240", "269", "260", "263")

            assertEquals(7, part1(input))
        }

        @Test
        internal fun `problem input`() {
            val input = readInput("Day01")

            assertEquals(1553, part1(input))
        }
    }

    @Nested
    inner class Part2 {
        @Test
        internal fun `simple cases`() {
            assertAll(
                { assertEquals(0, part2(listOf())) },
                { assertEquals(0, part2(listOf("1"))) },
                { assertEquals(0, part2(listOf("1", "2"))) },
                { assertEquals(0, part2(listOf("1", "2", "3"))) },
                { assertEquals(2, part2(listOf("1", "2", "3", "4", "5"))) },
                { assertEquals(3, part2(listOf("1", "2", "3", "4", "5", "7"))) }
            )
        }

        @Test
        internal fun `problem sample input`() {
            val input = listOf("199", "200", "208", "210", "200", "207", "240", "269", "260", "263")

            assertEquals(5, part2(input))
        }

        @Test
        internal fun `problem input`() {
            val input = readInput("Day01")

            assertEquals(1597, part2(input))
        }
    }
}
