package com.example.osonhisob.screens.calculatorscreen

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.osonhisob.R
import com.example.osonhisob.database.CalculationData
import com.example.osonhisob.database.CalculatorDatabase
import com.example.osonhisob.databinding.FragmentCalculatorBinding
import com.example.osonhisob.utils.toast
import com.google.android.material.snackbar.Snackbar


class CalculatorFragment : Fragment() {

    var calculationData = CalculationData()

    private lateinit var calculatorViewModel: CalculatorFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentCalculatorBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_calculator, container, false
        )


        val application = requireNotNull(this.activity).application
        var dataSource = CalculatorDatabase.getInstance(application).calculationDataDao


        val viewModelFactory = CalculatorFragmentViewModelFactory(dataSource, application)

        calculatorViewModel =
            ViewModelProvider(
                this, viewModelFactory
            ).get(CalculatorFragmentViewModel::class.java)

        setClicks(binding)
        setHasOptionsMenu(true)




        return binding.root
    }

    fun setClicks(binding: FragmentCalculatorBinding) {
        binding.key0.setOnClickListener {
            binding.outputLayout.addItem("0")
            calculationData = binding.outputLayout.getCalculationData()
        }
        binding.key1.setOnClickListener {
            binding.outputLayout.addItem("1")
            calculationData = binding.outputLayout.getCalculationData()
        }
        binding.key2.setOnClickListener {
            binding.outputLayout.addItem("2")
            calculationData = binding.outputLayout.getCalculationData()
        }
        binding.key3.setOnClickListener {
            binding.outputLayout.addItem("3")
            calculationData = binding.outputLayout.getCalculationData()
        }
        binding.key4.setOnClickListener {
            binding.outputLayout.addItem("4")
            calculationData = binding.outputLayout.getCalculationData()
        }
        binding.key5.setOnClickListener {
            binding.outputLayout.addItem("5")
            calculationData = binding.outputLayout.getCalculationData()
        }
        binding.key6.setOnClickListener {
            binding.outputLayout.addItem("6")
            calculationData = binding.outputLayout.getCalculationData()
        }
        binding.key7.setOnClickListener {
            binding.outputLayout.addItem("7")
            calculationData = binding.outputLayout.getCalculationData()
        }
        binding.key8.setOnClickListener {
            binding.outputLayout.addItem("8")
            calculationData = binding.outputLayout.getCalculationData()
        }
        binding.key9.setOnClickListener {
            binding.outputLayout.addItem("9")
            calculationData = binding.outputLayout.getCalculationData()
        }

        binding.keyDot?.setOnClickListener { binding.outputLayout.addItem(".") }
        binding.keyPercent.setOnClickListener { binding.outputLayout.addItem("%") }

        binding.keyClear.setOnClickListener { binding.outputLayout.clear() }
        binding.keyRemove.setOnClickListener { binding.outputLayout.removeItem() }
        binding.keyEqual.setOnClickListener {
            binding.outputLayout.solve()

        }


        binding.keyDivide.setOnClickListener { binding.outputLayout.addItem("/") }
        binding.keyMultiply.setOnClickListener { binding.outputLayout.addItem("*") }
        binding.keyMinus.setOnClickListener { binding.outputLayout.addItem("-") }
        binding.keyAdd.setOnClickListener { binding.outputLayout.addItem("+") }


    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.save_menu, menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {

            R.id.calculatorFragment -> {

                if (calculationData.resultText != "" || calculationData.calculationText != "") {

                    Snackbar.make(
                        requireActivity().findViewById(android.R.id.content),
                        "Сақланди",
                        Snackbar.LENGTH_SHORT // How long to display the message.
                    ).show()
                    calculatorViewModel.onSaveData(calculationData)
                } else {

                    Snackbar.make(
                        requireActivity().findViewById(android.R.id.content),
                        "Бўш",
                        Snackbar.LENGTH_SHORT // How long to display the message.
                    ).show()
                }

                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


}



