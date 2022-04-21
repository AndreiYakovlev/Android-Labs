package com.example.labs.ui.lab2.tasks

import kotlin.random.Random

class Task3 {
    data class Result(val rows: Int, val cols: Int, val a: Array<IntArray>, val b: Array<Boolean>)

    fun run(rows: Int, cols: Int): Result {
        val A = Array(rows) {
            IntArray(cols) {
                Random.nextInt(10) - 5
            }
        }

        val B = Array(cols) { colIndex ->
            (0 until rows).any { rowIndex ->
                A[rowIndex][colIndex].let {
                    it < 0 && it % 5 == 0
                }
            }
        }

        return Result(rows, cols, A, B)
    }
}