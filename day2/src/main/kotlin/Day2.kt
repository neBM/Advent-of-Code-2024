package uk.co.brmartin.adventofcode2024.app

import org.apache.commons.csv.CSVFormat.DEFAULT
import org.jetbrains.kotlinx.dataframe.DataFrame
import org.jetbrains.kotlinx.dataframe.DataRow
import org.jetbrains.kotlinx.dataframe.api.count
import org.jetbrains.kotlinx.dataframe.api.valuesOf
import org.jetbrains.kotlinx.dataframe.io.readDelim
import uk.co.brmartin.adventofcode2024.utils.InputsService
import java.io.StringReader
import kotlin.math.abs

fun main() {
//    BUG in Kotlin DataFrame: Rows must be sorted by their length
    val inputReader = InputsService()
        .getInputsForDay(2u)
        .readLines()
        .sortedByDescending { it.count { it == ' ' } }
        .joinToString("\n")
        .reader()
    val count = solve(inputReader)
    println(count)
}

fun solve(inputReader: StringReader): Int {
    val df = DataFrame.readDelim(inputReader, DEFAULT.builder().setDelimiter(' ').build())
    return df.count { predicate(it) }
}

private fun predicate(it: DataRow<Any?>) = isIncrementingWithinRange(it) && isAllStrictProgression(it)

private fun isAllStrictProgression(it: DataRow<Any?>) =
    it.valuesOf<Int>().zipWithNext().map { (a, b) -> a - b }.run { all { it > 0 } || all { it < 0 } }

private fun isIncrementingWithinRange(it: DataRow<Any?>) =
    it.valuesOf<Int>().zipWithNext().all { (a, b) -> abs(a - b) in 1..3 }
