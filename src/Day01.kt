fun main() {

    fun part1(input: List<String>): Int {
        return input
            .map { it.filter { c -> c.isDigit() } }
            .sumOf { "${it.first()}${it.last()}".toInt() }
    }

    fun part2(input: List<String>): Int {
        val words = listOf("one", "two", "three", "four", "five", "six", "seven", "eight", "nine")

        fun String.fixSpelling(): String {
            var res = ""
            forEachIndexed { i, c ->
                if (c.isDigit()) res += c

                words.forEachIndexed { index, word ->
                    if (length >= i + word.length) {
                        val substring = substring(i, i + word.length)
                        if (substring == word) res += index + 1
                    }
                }
            }
            return res
        }

        return part1(input.map(String::fixSpelling))
    }


    "Test part 1".println()
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 142)
    "Part 1".println()
    val input = readInput("Day01")
    part1(input).println()

    "Test part 2".println()
    val testInput2 = readInput("Day01_part2_test")
    check(part2(testInput2) == 281)

    "Part 2".println()
    val input2 = readInput("Day01_part2")
    part2(input2).println()
}
