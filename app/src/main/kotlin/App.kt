package uk.co.brmartin.adventofcode2024.app

import uk.co.brmartin.adventofcode2024.utils.Printer

// This is the main entry point of the application.
// It uses the `Printer` class from the `:utils` subproject.
fun main() {
    val message = "Hello JetBrains!"
    val printer = Printer(message)
    printer.printMessage()
}
