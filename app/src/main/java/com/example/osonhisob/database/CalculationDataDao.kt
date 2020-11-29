package com.example.osonhisob.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
interface CalculationDataDao {

    @Insert
    suspend fun insert(calculationData: CalculationData)

    @Update
    suspend fun update(calculationData: CalculationData)

    @Query("SELECT * from calculation_table WHERE calculationId = :key")
    suspend fun getCalculationById(key: Long): CalculationData?

    @Query("DELETE FROM calculation_table")
     suspend fun clearAll()

    @Query("SELECT * FROM calculation_table ORDER BY calculationId DESC")
     fun getAllCalculations(): LiveData<List<CalculationData>>

    //Actually i dont need this one
    @Query("SELECT * FROM calculation_table ORDER BY calculationId DESC LIMIT 1")
    suspend fun getCalculation(): CalculationData?

}

