import Day03.part1
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day03Test {
    @Nested
    inner class Part1 {
        @Test
        internal fun `power consumption is zero when the most common bit is zero`() {
            val result = part1(listOf("00000"))

            assertEquals(0, result)
        }

        @Test
        internal fun `power consumption is one when the converted value is one`() {
            val result = part1(listOf("00001"))

            assertEquals(1, result)
        }

        @Test
        internal fun `bits 10010 are converted to decimal 18`() {
            val result = part1(listOf("10010"))

            assertEquals(18, result)
        }
    }
}
