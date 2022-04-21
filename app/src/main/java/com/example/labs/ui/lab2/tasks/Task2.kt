package com.example.labs.ui.lab2.tasks

import kotlin.random.Random

class Task2 {
    data class Result(val a: Array<IntArray>, val b: IntArray)

    fun run(rows: Int, cols: Int): Result {
        val A = Array(rows) {
            IntArray(cols) {
                Random.nextInt(200)
            }
        }

        val B = IntArray(cols) { colIndex ->
            var count = 0
            repeat(rows) { rowIndex ->
                if (A[rowIndex][colIndex] in 10..100)
                    count++
            }
            count
        }

        return Result(A, B)
    }
}