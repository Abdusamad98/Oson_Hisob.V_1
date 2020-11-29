package com.example.osonhisob.screens.calculatorscreen

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.osonhisob.database.CalculationDataDao


class CalculatorFragmentViewModelFactory(
    private val dataSource: CalculationDataDao,
    private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CalculatorFragmentViewModel::class.java)) {
            return CalculatorFragmentViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
