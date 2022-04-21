package com.example.labs.ui.lab2.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.lifecycle.MutableLiveData
import com.example.labs.databinding.Lab2Task2LayoutBinding
import com.example.labs.ui.AppBottomDialog
import com.example.labs.ui.compose.Matrix
import com.example.labs.ui.lab2.tasks.Task2

class Task2DialogFragment : AppBottomDialog() {

    private var _binding: Lab2Task2LayoutBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val result = MutableLiveData<Task2.Result>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = Lab2Task2LayoutBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val rows = 4
        val cols = 5

        binding.btnSubmit.setOnClickListener {
            result.postValue(Task2().run(rows, cols))
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
                    Matrix(rows, cols) { row, col ->
                        it.a[row][col]
                    }
                }
            }

            binding.composeMatB.apply {
                setContent {
                    Matrix(1, cols) { _, col ->
                        result.value!!.b[col]
                    }
                }
            }
        }
        return root
    }
}