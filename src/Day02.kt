import Day02.part1
import Day02.part2
import java.lang.IllegalArgumentException

object Day02 {
    fun part1(input: List<String>): Int {
        val commands = input
            .map { it.split(" ") }
            .map { Command.from(it[0], it[1].toInt()) }
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

class Submarine(commands: List<Command>) {
    private var position: Position = Position()

    init {
        commands.forEach { command -> position = command.transform(position) }
    }

    fun positionValue(): Int = position.multiplied
}


interface Command {
    fun transform(position: Position): Position

    companion object {
        fun from(command: String, value: Int): Command = when (command) {
            "forward" -> Forward(value)
            "up" -> Up(value)
            "down" -> Down(value)
            else -> throw IllegalArgumentException("Invalid argument $command")
        }
    }
}

class Up(private val value: Int) : Command {
    override fun transform(position: Position): Position = position.minusDepth(value)
}

class Down(private val value: Int) : Command {
    override fun transform(position: Position): Position = position.addDepth(value)
}

class Forward(private val value: Int) : Command {
    override fun transform(position: Position): Position = position.moveForward(value)
}

fun main() {
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 150)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
