package uk.co.brmartin.adventofcode2024.app

import org.jetbrains.kotlinx.dataframe.api.column
import org.jetbrains.kotlinx.dataframe.api.count
import org.jetbrains.kotlinx.dataframe.api.dataFrameOf
import org.jetbrains.kotlinx.dataframe.api.mapToColumn
import org.jetbrains.kotlinx.dataframe.api.sum
import uk.co.brmartin.adventofcode2024.utils.InputSupplier.getInputForDay
import java.io.Reader

fun main() {
    val sum = solve(getInputForDay(1))
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


    val scoreDf = df.mapToColumn("score") { row -> row[a] * df[b].count { it == row[a] } }

    return scoreDf.sum()
}
