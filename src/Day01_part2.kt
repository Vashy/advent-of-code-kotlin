class MeasureWindows(private val measures: List<Measure>) {
    fun countIncreasingMeasures(): Int = toSweeps().countIncreasingMeasures()

    private fun toSweeps(): Sweeps {
        val list = measures.map { it.sum() }
        return Sweeps.from(list)
    }

    companion object {
        fun from(input: List<String>): MeasureWindows {
            val measures = input
                .zipWithNextTwo()
                .mapToIntTuple()
                .map(::Measure)
            return MeasureWindows(measures)
        }
    }
}

private fun List<Tuple<String>>.mapToIntTuple(): List<Triple<Int, Int, Int>> {
    return map { (first, second, third) -> Triple(first.toInt(), second.toInt(), third.toInt()) }
}

private typealias Tuple<T> = Triple<T, T, T>

private fun List<String>.zipWithNextTwo(): List<Tuple<String>> =
    mapIndexed { index, value ->
        if (index < size - 2)
            Tuple(value, this[index + 1], this[index + 2])
        else
            null
    }
        .filterNotNull()

class Measure(private val first: Int, private val second: Int, private val third: Int) {
    fun sum() = first + second + third

    constructor(triple: Triple<Int, Int, Int>) : this(triple.first, triple.second, triple.third)
}
