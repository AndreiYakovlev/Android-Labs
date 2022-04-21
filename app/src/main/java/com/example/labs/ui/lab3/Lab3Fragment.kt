package com.example.labs.ui.lab3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SimpleAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.labs.databinding.FragmentLab3Binding


class Lab3Fragment : Fragment() {

    private var _binding: FragmentLab3Binding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val viewModel: Lab3ViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentLab3Binding.inflate(inflater, container, false)
        val root: View = binding.root

        viewModel.list.observe(viewLifecycleOwner) {
            val users = it.map {
                HashMap<String, String>().apply {
                    this["Title"] = it.fio
                    this["Body"] = "${it.street}, д. ${it.house}, кв. ${it.apartment}"
                }
            }

            binding.listView.apply {
                adapter = SimpleAdapter(
                    requireContext(),
                    users,
                    android.R.layout.simple_list_item_2,
                    arrayOf("Title", "Body"),
                    arrayOf(android.R.id.text1, android.R.id.text2).toIntArray()
                )
            }
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}