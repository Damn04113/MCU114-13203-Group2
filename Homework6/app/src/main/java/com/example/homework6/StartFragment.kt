package com.example.homework6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.homework6.databinding.FragStartBinding

class StartFragment : Fragment() {

    private lateinit var binding: FragStartBinding
    private val viewModel: WorkViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragStartBinding.inflate(inflater, container, false)

        binding.btnStart.setOnClickListener {
            viewModel.startWork()
            (activity as MainActivity).goToProgressPage()
        }

        binding.btnCancel.setOnClickListener {
            viewModel.cancelWork()
        }

        return binding.root
    }
}
