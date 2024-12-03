package uk.co.brmartin.adventofcode2024.app

import org.jetbrains.kotlinx.dataframe.api.colsOf
import org.jetbrains.kotlinx.dataframe.api.column
import org.jetbrains.kotlinx.dataframe.api.dataFrameOf
import org.jetbrains.kotlinx.dataframe.api.mapToColumn
import org.jetbrains.kotlinx.dataframe.api.replace
import org.jetbrains.kotlinx.dataframe.api.sort
import org.jetbrains.kotlinx.dataframe.api.sum
import org.jetbrains.kotlinx.dataframe.api.with
import uk.co.brmartin.adventofcode2024.utils.InputsService
import java.io.Reader
import kotlin.math.abs

fun main() {
    val sum = solve(InputsService().getInputsForDay(1u))
    println(sum)
}

fun solve(inputReader: Reader): Int {
    val a by column<Int>()
    val b by column<Int>()

    val df = dataFrameOf(listOf(a.name(), b.name()),
        inputReader.useLines { lines ->
            lines.flatMap { line ->
                line
                    .split("   ")
                    .map(String::toInt)
            }.toList()
        })


    val sortedDf = df.replace { colsOf<Int>() }.with { it.sort() }

    val mapToColumn = sortedDf.mapToColumn("diff") { abs(it[a] - it[b]) }
    return mapToColumn.sum()
}
