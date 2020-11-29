package com.example.osonhisob.screens.penutcalhistoryscreen

import android.app.Application
import androidx.lifecycle.*
import com.example.osonhisob.database.CalculationData
import com.example.osonhisob.database.CalculationDataDao
import kotlinx.coroutines.launch

class HistoryViewModel(
    val database: CalculationDataDao,
    application: Application
) : AndroidViewModel(application) {

    val calculations = database.getAllCalculations()




    private suspend fun clear() {
        database.clearAll()
    }

        fun onClear() {
            viewModelScope.launch {
                // Clear the database table.
                clear()
            }


        }





}
