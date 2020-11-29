package com.example.osonhisob.screens.calculatorscreen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.osonhisob.database.CalculationData
import com.example.osonhisob.database.CalculationDataDao
import kotlinx.coroutines.launch


class CalculatorFragmentViewModel(
    val database: CalculationDataDao,
    application: Application
) : AndroidViewModel(application) {

    private suspend fun insert(calculationData: CalculationData) {
        database.insert(calculationData)
    }



    fun onSaveData(calculationData: CalculationData) {
        viewModelScope.launch {
            insert(calculationData)
        }
    }


}