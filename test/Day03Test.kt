import Day03.part1
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day03Test {
    @Nested
    inner class Part1 {
        @Test
        internal fun `power consumption is zero when the most common bit is zero`() {
            val result = part1(listOf("00000", "00000"))

            assertEquals(0, result)
        }

        @Test
        internal fun `power consumption is one when the converted value is one`() {
            val result = part1(listOf("00001"))

            assertEquals(30, result)
        }

        @Test
        internal fun `bits 10010 are converted to decimal 18`() {
            val result = part1(listOf("10010"))

            assertEquals(234, result)
        }

        @Test
        internal fun `power consumption takes the most common bit for each column`() {
            val result = part1(
                listOf(
                    "11000",
                    "00011",
                    "01010",
                )
            )

            assertEquals("01010".toInt(2) * "10101".toInt(2), result)
        }


        @Test
        internal fun `test input`() {
            val input = listOf(
                "00100",
                "11110",
                "10110",
                "10111",
                "10101",
                "01111",
                "00111",
                "11100",
                "10000",
                "11001",
                "00010",
                "01010",
            )

            val result = part1(input)

            assertEquals(198, result)
        }

        @Test
        internal fun `day 3 input`() {
            val result = part1(readInput("Day03"))

            assertEquals(4160394, result)
        }
    }
}
