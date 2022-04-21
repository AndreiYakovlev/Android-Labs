package com.example.labs.ui.lab1.tasks

class Task3 {
    data class Result(val numbers: List<Int>)

    fun run(a: Int, b: Int, S: Int): Result {
        val numbers = (a..b).filter { i ->
            val str = i.toString()
            val sum = str.sumOf { ch -> ch.digitToInt() }
            sum == S
        }.toList()
        return Result(numbers)
    }
}