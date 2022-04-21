package com.example.labs.ui.lab1.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.labs.databinding.Lab1Task3LayoutBinding
import com.example.labs.ui.AppBottomDialog
import com.example.labs.ui.lab1.tasks.Task3

class Task3DialogFragment : AppBottomDialog() {

    private var _binding: Lab1Task3LayoutBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = Lab1Task3LayoutBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.btnSubmit.setOnClickListener {
            val a = binding.editInput1.text.toString().toIntOrNull()
            val b = binding.editInput2.text.toString().toIntOrNull()
            val sum = binding.editInput3.text.toString().toIntOrNull()

            if (a == null || b == null || sum == null) {
                binding.textResult.text = "Введите корректные числа"
            } else {
                val result = Task3().run(a, b, sum)
                binding.textResult.text =
                    if (result.numbers.isNotEmpty()) result.numbers.joinToString(",") else "Таких чисел нет"
            }
        }

        return root
    }
}