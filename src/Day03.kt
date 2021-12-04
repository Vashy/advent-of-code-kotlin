object Day03 {
    fun part1(input: List<String>): Int {
        val bits: CharArray = input
            .map { it.toCharArray() }
            .first()

        return if (bits[0] == '1') 1 else 0
    }

    fun part2(input: List<String>): Int {
        return 0
    }
}

fun main() {
//    val testInput = readInput("Day03_test")
//    check(part1(testInput) == 150)
//
//    val input = readInput("Day03")
//    println(part1(input))
//    println(part2(input))
    val bytes: ByteArray = ByteArray(5)
    bytes[0] = 127
    bytes[1] = 11
    bytes[2] = 107
//    bytes[3] = 0xff
    val a: Int = 0b000101

    val parseInt = Integer.parseInt("10010", 2)

    println(parseInt)
}
