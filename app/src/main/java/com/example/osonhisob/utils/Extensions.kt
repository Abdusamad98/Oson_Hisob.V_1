package com.example.osonhisob.utils

import android.R
import android.content.Context
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

fun Spinner.addItems(context: Context, data: ArrayList<String>){
    val aa: ArrayAdapter<String> = ArrayAdapter(context, R.layout.simple_spinner_item, data)
    aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
    adapter = aa
}

fun convertLongToTime(time: Long): String {
    val date = Date(time)
    val format = SimpleDateFormat("yyyy.MM.dd HH:mm")
    return format.format(date)
}
private var toast: Toast? = null
fun toast(context: Context, message: String) {
    toast?.apply { cancel() }
    toast = Toast.makeText(context, message, Toast.LENGTH_SHORT).apply { show() }
}


fun getTerishNarxi(spinner: Spinner): Double {
    var som = 0.0
    when (spinner.selectedItemPosition) {
        0 -> som = 200.0
        1 -> som = 250.0
        2 -> som = 300.0
        3 -> som = 350.0
        4 -> som = 400.0
        5 -> som = 450.0
        6 -> som = 500.0
        7 -> som = 550.0
        8 -> som = 600.0
    }


    return som
}







fun getFoiz(spinner: Spinner): Double {
    var qism = 0.0
    when (spinner.selectedItemPosition) {
        0 -> qism = 0.3
        1 -> qism = 0.4
        2 -> qism = 0.45
        3 -> qism = 0.48
        4 -> qism = 0.5
        5 -> qism = 0.52
        6 -> qism = 0.54
        7 -> qism = 0.55
        8 -> qism = 0.56
        9 -> qism = 0.57
        10 -> qism = 0.58
        11 -> qism = 0.59
        12 -> qism = 0.60
        13 -> qism = 0.61
        14 -> qism = 0.62
        15 -> qism = 0.63
        16 -> qism = 0.64
        17 -> qism = 0.65
        18 -> qism = 0.66
        19 -> qism = 0.67
        20 -> qism = 0.68
        21 -> qism = 0.69
        22 -> qism = 0.70
        23 -> qism = 0.71
        24 -> qism = 0.72
    }
    return qism
}


fun getYongoqRubbish(spinner: Spinner): Double {
    var massa = 0.0
    when (spinner.selectedItemPosition) {
        0 -> massa = 0.3
        1 -> massa = 0.4
        2 -> massa = 0.5
        3 -> massa = 0.6
        4 -> massa = 0.7
        5 -> massa = 0.8
        6 -> massa = 0.9
        7 -> massa = 1.0
        8 -> massa = 1.1
        9 -> massa = 1.2
        10 -> massa = 1.3
        11 -> massa = 1.4
        12 -> massa = 1.5
        13 -> massa = 1.6
        14 -> massa = 1.7
        15 -> massa = 1.8
        16 -> massa = 1.9
        17 -> massa = 2.0
        18 -> massa = 2.1
        29 -> massa = 2.2
        20 -> massa = 2.3
        21 -> massa = 2.4
        22 -> massa = 2.5
        23 -> massa = 3.0
        24 -> massa = 3.5
        25 -> massa = 4.0
        26 -> massa = 4.5
        27 -> massa = 5.0
        28 -> massa = 5.5
        29 -> massa = 6.0
        30 -> massa = 6.5
        31 -> massa = 7.0
        32 -> massa = 7.5
        33 -> massa = 8.0
        34 -> massa = 9.0
        35 -> massa = 10.0


    }
    return massa
}


fun getMagizRubbish(spinner: Spinner): Double {
    var massa = 0.0
    when (spinner.selectedItemPosition) {
        0 -> massa = 0.3
        1 -> massa = 0.5
        2 -> massa = 0.8
        3 -> massa = 1.0
        4 -> massa = 2.0
        5 -> massa = 3.0
        6 -> massa = 4.0
        7 -> massa = 5.0
    }


    return massa
}


fun getMagizSechka(spinner: Spinner): Double {
    var massa = 0.0
    when (spinner.selectedItemPosition) {
        0 -> massa = 1.0
        1 -> massa = 2.0
        2 -> massa = 3.0
        3 -> massa = 4.0
        4 -> massa = 5.0
        5 -> massa = 6.0
        6 -> massa = 7.0
        7 -> massa = 8.0
        8 -> massa = 9.0
        9 -> massa = 10.0
        10 -> massa = 11.0

        11 -> massa = 12.0
        12 -> massa = 13.0
        13 -> massa = 14.0
        14 -> massa = 15.0
        15 -> massa = 16.0
        16 -> massa = 17.0
        17 -> massa = 18.0
        18 -> massa = 19.0
        19 -> massa = 20.0
        20 -> massa = 21.0

        21 -> massa = 22.0
        22 -> massa = 23.0
        23 -> massa = 24.0
        24 -> massa = 25.0
        25 -> massa = 26.0
        26 -> massa = 27.0
        27 -> massa = 28.0
        28 -> massa = 29.0
        29 -> massa = 30.0
    }


    return massa
}



fun getTermaFoiz(spinner: Spinner): Double {
    var qism = 0.0
    when (spinner.selectedItemPosition) {
        0 -> qism = 0.5
        1 -> qism = 0.51
        2 -> qism = 0.52
        3 -> qism = 0.53
        4 -> qism = 0.54
        5 -> qism = 0.55
        6 -> qism = 0.56
        7 -> qism = 0.57
        8 -> qism = 0.58
        9 -> qism = 0.59
        10 -> qism = 0.6
        11 -> qism = 0.61
        12 -> qism = 0.62
        13 -> qism = 0.63
        14 -> qism = 0.64
        15 -> qism = 0.65
        16 -> qism = 0.66
        17 -> qism = 0.67
        18 -> qism = 0.68
        19 -> qism = 0.69
        20 -> qism = 0.7
        21 -> qism = 0.71
        22 -> qism = 0.72
        23 -> qism = 0.73
        24 -> qism = 0.74

        25 -> qism = 0.75
        26 -> qism = 0.76
        27 -> qism = 0.77
        28 -> qism = 0.78
        29 -> qism = 0.79
        30 -> qism = 0.8
        31 -> qism = 0.81
        32 -> qism = 0.82
        33 -> qism = 0.84
        34 -> qism = 0.85
        35 -> qism = 0.86

    }
    return qism
}

//Listeners


