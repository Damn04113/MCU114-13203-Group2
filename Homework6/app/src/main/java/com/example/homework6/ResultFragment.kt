package com.example.homework6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.homework6.databinding.FragResultBinding

class ResultFragment : Fragment() {

    private lateinit var binding: FragResultBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragResultBinding.inflate(inflater, container, false)
        binding.txtResult.text = "工作完成 ✅"
        return binding.root
    }
}
