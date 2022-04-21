package com.example.labs.ui.lab2.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.lifecycle.MutableLiveData
import com.example.labs.databinding.Lab2Task3LayoutBinding
import com.example.labs.ui.AppBottomDialog
import com.example.labs.ui.compose.Matrix
import com.example.labs.ui.lab2.tasks.Task3

class Task3DialogFragment : AppBottomDialog() {

    private var _binding: Lab2Task3LayoutBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val result = MutableLiveData<Task3.Result>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = Lab2Task3LayoutBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.btnSubmit.setOnClickListener {
            val rows = binding.editInput1.text.toString().toIntOrNull()
            val cols = binding.editInput2.text.toString().toIntOrNull()
            if (rows != null && cols != null) {
                result.postValue(Task3().run(rows, cols))
            }
        }

        binding.composeMatA.apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
        }

        binding.composeMatB.apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
        }

        result.observe(viewLifecycleOwner) {
            binding.composeMatA.apply {
                setContent {
                    Matrix(it.rows, it.cols) { row, col -> it.a[row][col] }
                }
            }

            binding.composeMatB.apply {
                setContent {
                    Matrix(1, it.cols) { _, col ->
                        it.b[col]
                    }
                }
            }
        }
        return root
    }
}