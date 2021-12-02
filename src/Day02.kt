import Day02.part1
import Day02.part2

object Day02 {
    fun part1(input: List<String>): Int {
        val map: List<Int> = input
            .map { it.split(" ") }
            .map { it[1].toInt() }
        return map.firstOrNull()?.minus(map.getOrElse(1) { 0 }) ?: 0
    }

    fun part2(input: List<String>): Int {
        return 0
    }
}

fun main() {
    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 7)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
