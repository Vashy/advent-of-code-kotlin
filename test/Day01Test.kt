import Day01.part1
import org.junit.jupiter.api.assertAll
import kotlin.test.Test
import kotlin.test.assertEquals

class Day01Test {
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
    internal fun `complex case`() {
        assertEquals(4, part1(listOf("5", "4", "3", "4", "5", "6", "7", "3")))
    }
}