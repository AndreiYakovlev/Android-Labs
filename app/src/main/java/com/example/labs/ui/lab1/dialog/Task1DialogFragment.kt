package com.example.labs.ui.lab1.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.labs.databinding.Lab1Task1LayoutBinding
import com.example.labs.ui.AppBottomDialog
import com.example.labs.ui.lab1.tasks.Task1

class Task1DialogFragment : AppBottomDialog() {

    private var _binding: Lab1Task1LayoutBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = Lab1Task1LayoutBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.btnSubmit.setOnClickListener {
            binding.editInput.text.toString().toIntOrNull()?.let { input ->
                val result = Task1().run(input.toString())
                binding.textResult1.text = result.mul.toString()
                binding.textResult2.text = if (result.hasMod3) "Не верно" else "Верно"
            } ?: run {
                binding.textResult1.text = "?"
                binding.textResult2.text = "?"
            }
        }
        return root
    }
}