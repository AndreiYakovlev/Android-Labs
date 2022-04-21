package com.example.labs.ui.lab1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.labs.databinding.FragmentLab1Binding
import com.example.labs.ui.lab1.dialog.Task1DialogFragment
import com.example.labs.ui.lab1.dialog.Task2DialogFragment
import com.example.labs.ui.lab1.dialog.Task3DialogFragment
import com.example.labs.ui.lab1.dialog.Task4DialogFragment

class Lab1Fragment : Fragment() {

    private var _binding: FragmentLab1Binding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentLab1Binding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.btnTask1.setOnClickListener {
            Task1DialogFragment().show(parentFragmentManager, "tag")
        }

        binding.btnTask2.setOnClickListener {
            Task2DialogFragment().show(parentFragmentManager, "tag")
        }

        binding.btnTask3.setOnClickListener {
            Task3DialogFragment().show(parentFragmentManager, "tag")
        }

        binding.btnTask4.setOnClickListener {
            Task4DialogFragment().show(parentFragmentManager, "tag")
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}