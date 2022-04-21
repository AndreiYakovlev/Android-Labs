package com.example.labs.ui.lab1.tasks

import kotlin.math.*

class Task4 {

    fun run(x: Double, y: Double): Double {
        return when {
            x < 0 -> {
                abs(x + exp(y)) / sqrt((abs(x) + 5))
            }
            x > 3 -> {
                abs(ln(abs(y)) - ln((x * x))) / sqrt(x)
            }
            else -> {
                (y + cos(x)).pow(2.0) + Math.PI
            }
        }
    }
}