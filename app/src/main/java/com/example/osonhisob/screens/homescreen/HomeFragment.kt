package com.example.osonhisob.screens.homescreen

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.osonhisob.R
import com.example.osonhisob.databinding.FragmentHomeBinding

class HomeFragment: Fragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding: FragmentHomeBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_home, container, false)


        binding.calculatorScreen.setOnClickListener { v: View ->
            v.findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToCalculatorFragment())
        }
        binding.peanutShellScreen.setOnClickListener { v: View ->
            v.findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToTermaFragment())
        }

        binding.penutScreen.setOnClickListener { v: View ->
            v.findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToPeanutFragment())
        }

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }
}


