package com.example.labs.ui.lab1.tasks

class Task1 {

    data class Result(val mul: Int, val hasMod3: Boolean);

    fun run(input: String): Result {
        var hasMod3 = false
        var mul = 0
        input.forEach {
            val digit = it.digitToInt();
            if (digit % 2 != 0) {
                mul = if (mul == 0) digit else mul * digit
            }

            if (digit % 3 == 0)
                hasMod3 = true
        }

        return Result(mul, hasMod3)
    }
}