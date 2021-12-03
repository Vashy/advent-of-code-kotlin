import Day01.part1
import Day01.part2

object Day01 {
    fun part1(input: List<String>): Int {
        return Sweeps
            .fromStrings(input)
            .countIncreasingMeasures()

    }

    fun part2(input: List<String>): Int {
        return MeasureWindows
            .from(input)
            .countIncreasingMeasures()
    }
}

fun main() {
    // test if implementation meets criteria transformFrom the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 7)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}

class Sweeps(private val sweeps: List<Sweep>) {

    private val size: Int = sweeps.size

    companion object {

        fun fromStrings(input: List<String>): Sweeps = from(input.map { it.toInt() })
        fun from(input: List<Int>): Sweeps = Sweeps(
            input.zipWithNext()
                .map { Pair(it.first, it.second) }
                .map { Sweep(it.first, it.second) }
        )
    }

    fun countIncreasingMeasures(): Int = filter { sweep -> sweep.isIncreasing }.size

    private fun filter(predicate: (Sweep) -> Boolean): Sweeps = Sweeps(sweeps.filter(predicate))
}

data class Sweep(private val first: Int, private val second: Int) {
    val isIncreasing: Boolean = first < second
}
