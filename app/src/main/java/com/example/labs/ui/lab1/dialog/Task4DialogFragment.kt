package com.example.labs.ui.lab1.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.labs.databinding.Lab1Task4LayoutBinding
import com.example.labs.ui.AppBottomDialog
import com.example.labs.ui.lab1.tasks.Task4
import kotlin.random.Random

class Task4DialogFragment : AppBottomDialog() {

    private var _binding: Lab1Task4LayoutBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = Lab1Task4LayoutBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.btnRnd.setOnClickListener {
            binding.editInput1.setText(Random.nextInt(-10, 20 + 1).toString())
            binding.editInput2.setText(Random.nextInt(-10, 20 + 1).toString())
        }
        binding.btnSubmit.setOnClickListener {
            val a = binding.editInput1.text.toString().toIntOrNull()
            val b = binding.editInput2.text.toString().toIntOrNull()

            if (a == null || b == null) {
                binding.textResult.text = "Введите корректные целые числа"
            } else {
                val result = Task4().run(a.toDouble(), b.toDouble())
                binding.textResult.text = "%.3f".format(result)
            }
        }

        return root
    }
}