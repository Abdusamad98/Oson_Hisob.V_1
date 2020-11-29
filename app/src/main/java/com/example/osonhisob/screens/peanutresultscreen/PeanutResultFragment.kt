package com.example.osonhisob.screens.peanutresultscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.osonhisob.R
import com.example.osonhisob.databinding.FragmentPeanutBinding
import com.example.osonhisob.databinding.FragmentPeanutResultBinding

class PeanutResultFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentPeanutResultBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_peanut_result, container, false
        )


        val peanutResultFragmentArgs by navArgs<PeanutResultFragmentArgs>()


        binding.reportText.setText(peanutResultFragmentArgs.report)


        return binding.root
    }


}