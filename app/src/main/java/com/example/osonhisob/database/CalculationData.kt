package com.example.osonhisob.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey



@Entity(tableName = "calculation_table")

class CalculationData(
    @PrimaryKey(autoGenerate = true)
    var calculationId: Long = 0L,

    @ColumnInfo(name = "saved_time")
    val savedTime: Long = System.currentTimeMillis(),

    @ColumnInfo(name = "calculation_text")
    var calculationText: String ="",

    @ColumnInfo(name = "result_text")
     var resultText: String =""


)
