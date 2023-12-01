data class PossibleValue(val string: String, val digit: Int)

fun main() {
    fun firstDigit(it: String) = it.first { c -> c.isDigit() }

    fun lastDigit(it: String) = it.last { c -> c.isDigit() }

    fun part1(input: List<String>): Int {
        return input.sumOf { "${firstDigit(it)}${lastDigit(it)}".toInt() }
    }

    fun part2(input: List<String>): Int {
        val stringPossible = listOf(
            PossibleValue("one", 1),
            PossibleValue("two", 2),
            PossibleValue("three", 3),
            PossibleValue("four", 4),
            PossibleValue("five", 5),
            PossibleValue("six", 6),
            PossibleValue("seven", 7),
            PossibleValue("eight", 8),
            PossibleValue("nine", 9)
        )
        return input.sumOf {
            val first = stringPossible.firstOrNull { p -> it.startsWith(p.string) }?.digit ?: firstDigit(it)
            val second = stringPossible.lastOrNull { p -> it.endsWith(p.string) }?.digit ?: lastDigit(it)
            "$first$second".toInt()
        }
    }


    "Test part 1".println()
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 142)
    "Part 1".println()
    val input = readInput("Day01")
    part1(input).println()

    "Test part 2".println()
    val testInput2 = readInput("Day01_part2_test")
    check(part1(testInput2) == 281)

    "Part 2".println()
    part2(input).println()
}
