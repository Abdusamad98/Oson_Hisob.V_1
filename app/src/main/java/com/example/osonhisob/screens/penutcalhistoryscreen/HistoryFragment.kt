package com.example.osonhisob.screens.penutcalhistoryscreen

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.osonhisob.R
import com.example.osonhisob.adapters.CalculationAdapter
import com.example.osonhisob.database.CalculationData
import com.example.osonhisob.database.CalculatorDatabase
import com.example.osonhisob.databinding.FragmentHistoryBinding
import com.example.osonhisob.utils.toast
import java.util.*
import kotlin.collections.ArrayList
import kotlin.concurrent.schedule

class HistoryFragment : Fragment() {
    private lateinit var adapter: CalculationAdapter
    private lateinit var data: ArrayList<CalculationData>
    private lateinit var historyViewModel: HistoryViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentHistoryBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_history, container, false
        )

        val application = requireNotNull(this.activity).application

        val dataSource = CalculatorDatabase.getInstance(application).calculationDataDao

        val viewModelFactory = HistoryViewModelFactory(dataSource, application)

        val historyViewModel =
            ViewModelProvider(
                this, viewModelFactory).get(HistoryViewModel::class.java)

        binding.historyViewModel = historyViewModel

        binding.lifecycleOwner = this

        historyViewModel.calculations.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter = CalculationAdapter(it as ArrayList<CalculationData>)
                toast(context!!, it.size.toString())
                binding.calculationsList.adapter = adapter
                binding.calculationsList.layoutManager = LinearLayoutManager(context)
            }
        })





        binding.floatButton.setOnClickListener {
            AlertDialog.Builder(context!!).setTitle("Еслатма!")
                .setMessage("Хақиқатдан ўчирилсинми?")
                .setPositiveButton("Ok") { dialog, _ ->
                    historyViewModel.onClear()
                    data.clear()
                    adapter.notifyDataSetChanged()
                    dialog.cancel()
                }.setNegativeButton("Cancel") { d, _ ->
                    d.cancel()
                }.show()
        }


        // setHasOptionsMenu(true)

        return binding.root
    }
}