package com.example.labs.ui.lab1.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.labs.databinding.Lab1Task2LayoutBinding
import com.example.labs.ui.AppBottomDialog
import com.example.labs.ui.lab1.tasks.Task2

class Task2DialogFragment : AppBottomDialog() {

    private var _binding: Lab1Task2LayoutBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = Lab1Task2LayoutBinding.inflate(inflater, container, false)
        val root: View = binding.root
        binding.btnSubmit.setOnClickListener {
            val a = binding.editInput1.text.toString().toIntOrNull()
            val b = binding.editInput2.text.toString().toIntOrNull()

            if (a == null || b == null) {
                binding.textResult.text = "Введите трехзначные числа"
            } else {
                if (a.toString().length == 3 && b.toString().length == 3) {
                    val result = Task2().run(a, b)
                    binding.textResult.text = result.numbers.size.toString()
                } else {
                    binding.textResult.text = "Только трехзначные числа"
                }
            }
        }
        return root
    }
}