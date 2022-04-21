package com.example.labs.ui.lab1.tasks

class Task2 {
    data class Result(val numbers: List<Int>)

    fun run(a: Int, b: Int): Result {
        val numbers = (a..b).filter {
            val str = it.toString()
            val first = str.first().digitToInt()
            val last = str.last().digitToInt()
            first * last == 12
        }.toList()

        return Result(numbers)
    }
}