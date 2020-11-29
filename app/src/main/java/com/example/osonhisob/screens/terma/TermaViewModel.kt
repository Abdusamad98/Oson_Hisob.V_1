package com.example.osonhisob.screens.terma

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class TermaViewModel:ViewModel()  {


    private var _input1 = MutableLiveData<Int?>()

    val input1: LiveData<Int?>
        get() = _input1


    private var _input2 = MutableLiveData<Int?>()

    val input2: LiveData<Int?>
        get() = _input2



    private var _input3 = MutableLiveData<Int?>()

    val input3: LiveData<Int?>
        get() = _input3


    private var _input4 = MutableLiveData<Int?>()

    val input4: LiveData<Int?>
        get() = _input4



    var result1 = MutableLiveData<String?>()

    var result2 = MutableLiveData<String?>()

    var result3 = MutableLiveData<String?>()

    var result4 = MutableLiveData<String?>()

    var result5 = MutableLiveData<String?>()


}
