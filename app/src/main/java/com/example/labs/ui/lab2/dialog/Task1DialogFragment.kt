package com.example.labs.ui.lab2.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.labs.databinding.Lab2Task1LayoutBinding
import com.example.labs.ui.AppBottomDialog
import com.example.labs.ui.lab2.tasks.Task1

class Task1DialogFragment : AppBottomDialog() {

    private var _binding: Lab2Task1LayoutBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = Lab2Task1LayoutBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.btnSubmit.setOnClickListener {

            val arr = binding.editInput1.text
                .split(",")
                .map { it.toInt() }
                .toIntArray()

            val job1Result = Task1.Job1().run(arr)
            val job2Result = Task1.Job2().run(arr)
            val job3Result = Task1.Job3().run(arr)
            val job4Result = Task1.Job4().run(arr)

            binding.textResult1.text = job1Result.toString()
            binding.textResult2.text = job2Result.toString()
            binding.textResult3.text = job3Result.toString()
            binding.textResult4.text = job4Result.toString()
        }

        return root
    }
}