package com.example.labs.ui.lab2.tasks

class Task1 {
    class Job1 {
        data class Result(val positiveCount: Int, val negativeCount: Int, val modBy3: Int) {
            override fun toString(): String =
                "Положительных чисел: $positiveCount, Отрицательных чисел: $negativeCount, Чисел кратные 3: $modBy3"
        }

        fun run(arr: IntArray): Result {
            var positiveCount = 0
            var negativeCount = 0
            var modBy3 = 0 // Кол-во чисел кратных 3

            for (num in arr) {
                //В данном случае, 0 считается положительных числом
                if (num < 0) {
                    negativeCount++
                } else positiveCount++
                if (num % 3 == 0) modBy3++
            }
            return Result(positiveCount, negativeCount, modBy3)
        }
    }

    class Job2 {
        data class Result(val num: Int?) {
            override fun toString(): String {
                return num?.toString() ?: "Не найден"
            }
        }

        fun run(arr: IntArray): Result {
            var positiveCount = 0
            for (num in arr) {
                if (num > 0 && num % 3 == 0) positiveCount++
                if (positiveCount == 4) {
                    return Result(num)
                }
            }
            return Result(null)
        }
    }

    class Job3 {
        data class Result(val newArr: IntArray?) {
            override fun toString(): String {
                return newArr?.joinToString() ?: "Не найден"
            }
        }

        fun run(arr: IntArray): Result {
            val arrCopy = arr.clone()
            for (i in arrCopy.indices.reversed()) {
                val num = arrCopy[i]
                if (num > 0 && num % 2 != 0) {
                    arrCopy[i] = 0
                    return Result(arrCopy)
                }
            }
            return Result(null)
        }
    }

    class Job4 {
        data class Result(val newArr: IntArray) {
            override fun toString(): String {
                return newArr.joinToString()
            }
        }

        fun run(arr: IntArray): Result {
            val arrCopy = arr.clone()
            arrCopy.sort()
            val min = arrCopy.first() //Минимальный элемент в начале
            val max = arrCopy.last() //Макс. элем. в конце

            for (i in arr.indices) {
                when {
                    arr[i] == min -> {
                        arrCopy[i] = max
                    }
                    arr[i] == max -> {
                        arrCopy[i] = min
                    }
                    else -> arrCopy[i] = arr[i]
                }
            }
            return Result(arrCopy)
        }
    }
}