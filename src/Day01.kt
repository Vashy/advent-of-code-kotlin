import Day01.part1
import Day01.part2

object Day01 {
    fun part1(input: List<String>): Int {
        return Sweeps
            .from(input)
            .filter { sweep -> sweep.isIncreasing }
            .size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }
}

class Sweeps(private val sweeps: List<Sweep>) {
    val size: Int = sweeps.size

    companion object {
        fun from(input: List<String>): Sweeps = Sweeps(
            input.zipWithNext()
                .map { Pair(it.first.toInt(), it.second.toInt()) }
                .map { Sweep(it.first, it.second) }
        )
    }

    fun filter(predicate: (Sweep) -> Boolean): Sweeps = Sweeps(sweeps.filter(predicate))
}

data class Sweep(private val first: Int, private val second: Int) {
    val isIncreasing: Boolean = first < second
}

fun main() {

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 7)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
