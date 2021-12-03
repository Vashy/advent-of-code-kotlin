import Day02.part1
import Day02.part2

object Day02 {
    fun part1(input: List<String>): Int {
        val commands = input
            .map { it.toPair() }
            .map { (name, value) -> transformFrom(name, value) }
        val submarine = Submarine.withSimplePosition(commands)

        return submarine.positionValue()
    }

    fun part2(input: List<String>): Int {
        val commands = input
            .map { it.toPair() }
            .map { (name, value) -> transformFrom(name, value) }
        val submarine = Submarine.withImprovedPosition(commands)

        return submarine.positionValue()
    }
}

interface Position {
    val multiplied: Int

    fun moveUpBy(value: Int): Position
    fun moveDownBy(value: Int): Position
    fun moveForwardBy(value: Int): Position
}

class SimplePosition(private val horizontal: Int = 0, private val depth: Int = 0): Position {
    override val multiplied: Int = if (horizontal == 0 && depth == 0) 0 else horizontal.orOne() * depth.orOne()

    override fun moveUpBy(value: Int) = SimplePosition(horizontal, depth - value)
    override fun moveDownBy(value: Int): SimplePosition = SimplePosition(horizontal, depth + value)
    override fun moveForwardBy(value: Int): SimplePosition = SimplePosition(horizontal + value, depth)

    private fun Int.orOne(): Int = if (this == 0) 1 else this
}

class ImprovedPosition(
    private val horizontal: Int = 0,
    private val aim: Int = 0,
    private val depth: Int = 0
): Position by SimplePosition(horizontal, depth) {
    override fun moveUpBy(value: Int): Position {
        return ImprovedPosition(horizontal, aim - value, depth)
    }

    override fun moveDownBy(value: Int): Position {
        return ImprovedPosition(horizontal, aim + value, depth)
    }

    override fun moveForwardBy(value: Int): Position {
        return ImprovedPosition(horizontal + value, aim, depth + aim * value)
    }
}

class Submarine private constructor(private var position: Position, transformations: List<Transform>) {
    companion object {
        fun withSimplePosition(transformations: List<Transform>): Submarine {
            return Submarine(SimplePosition(), transformations)
        }

        fun withImprovedPosition(transformations: List<Transform>): Submarine {
            return Submarine(ImprovedPosition(), transformations)
        }
    }

    init {
        transformations.forEach { transform -> position = transform(position) }
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

fun Up(value: Int): Transform = { position -> position.moveUpBy(value) }

fun Down(value: Int): Transform = { position -> position.moveDownBy(value) }

fun Forward(value: Int): Transform = { position -> position.moveForwardBy(value) }

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
