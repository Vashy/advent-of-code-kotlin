import Day02.part1
import Day02.part2

object Day02 {
    fun part1(input: List<String>): Int {
        val commands = input
            .map { it.toPair() }
            .map { (name, value) -> transformFrom(name, value) }
        val submarine = Submarine(commands)

        return submarine.positionValue()
    }

    fun part2(input: List<String>): Int {
        return 0
    }
}

class Position(private val horizontal: Int = 0, private val depth: Int = 0) {
    val multiplied: Int = if (horizontal == 0 && depth == 0) 0 else horizontal.orOne() * depth.orOne()

    fun minusDepth(depth: Int) = Position(horizontal, this.depth - depth)
    fun addDepth(depth: Int): Position = Position(horizontal, this.depth + depth)
    fun moveForward(horizontal: Int): Position = Position(this.horizontal + horizontal, depth)

    private fun Int.orOne(): Int = if (this == 0) 1 else this
}

class Submarine(transforms: List<Transform>) {
    private var position: Position = Position()

    init {
        transforms.forEach { transform -> position = transform(position) }
    }

    fun positionValue(): Int = position.multiplied
}

typealias Transform = (Position) -> Position

fun transformFrom(command: String, value: Int): Transform = when (command) {
    "forward" -> Forward(value)
    "up" -> Up(value)
    "down" -> Down(value)
    else -> throw IllegalArgumentException("Invalid argument $command")
}

fun Up(value: Int): Transform = { position -> position.minusDepth(value) }

fun Down(value: Int): Transform = { position -> position.addDepth(value) }

fun Forward(value: Int): Transform = { position -> position.moveForward(value) }

private fun String.toPair(): Pair<String, Int> {
    val split = split(" ")
    return Pair(split[0], split[1].toInt())
}

fun main() {
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 150)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
