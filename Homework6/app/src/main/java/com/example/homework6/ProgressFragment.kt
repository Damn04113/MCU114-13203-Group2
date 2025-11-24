package com.example.homework6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.homework6.databinding.FragProgressBinding

class ProgressFragment : Fragment() {

    private lateinit var binding: FragProgressBinding
    private val viewModel: WorkViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragProgressBinding.inflate(inflater, container, false)

        viewModel.progress.observe(viewLifecycleOwner) { percent ->
            binding.progressBar.progress = percent
            binding.txtPercent.text = "$percent%"
        }

        return binding.root
    }
}
