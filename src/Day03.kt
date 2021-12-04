import Day03.part1

object Day03 {
    fun part1(input: List<String>): Int {
        val (gamma, epsilon) = invertMatrix(input)
        println("gamma: $gamma")
        println("epsilon: $epsilon")
        return (gamma.toInt(2) * epsilon.toInt(2))
    }

    private fun invertMatrix(input: List<String>): Pair<String, String> {
        var gamma = ""
        var epsilon = ""
        for (index in 0 until input[0].length) {
            val map = mutableMapOf<Char, Int>()
            for (value in input) {
                map[value[index]] = map.getOrDefault(value[index], 0) + 1
            }

            if (map.getOrDefault('0', 0) > map.getOrDefault('1', 0)) {
                gamma += "0"
                epsilon += "1"
            } else {
                gamma += "1"
                epsilon += "0"
            }
        }
//        println("gamma: $gamma")
//        println("epsilon: $epsilon")
        return Pair(gamma, epsilon)
    }
}

fun part2(input: List<String>): Int {
    return 0
}

fun main() {
    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}
