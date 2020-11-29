package com.example.osonhisob.calculator

import bsh.Interpreter
import com.example.osonhisob.database.CalculationData
import com.example.osonhisob.utils.toast
import kotlinx.android.synthetic.main.view_calculator_output.view.*
import java.lang.Exception

object CalculatorOutputPresenter {
    private var onView: CalculatorOutputInterfaceView? = null

    private var onCurrentEquation: String = ""
    private var onCurrentOutcome: String = ""

    private var onIterpreter = Interpreter()


    fun attach(view: CalculatorOutputInterfaceView) {
        onView = view
        updateOutcome()
        updateEquation()
    }

    fun detach() {
        onView = null
    }


    fun add(item: String) {

        if(item.equals("%")||item.equals(".")||item.equals("+")||item.equals("-")||item.equals("*")||item.equals("/"))
        {
            if(onCurrentEquation.isNotEmpty()&&onCurrentEquation.last().isDigit()){
                onCurrentEquation = onCurrentEquation.plus(item)
            }

        }
        else  onCurrentEquation = onCurrentEquation.plus(item)

        calculateOutcome()
        updateEquation()
        updateOutcome()

    }

    fun remove() {
        onCurrentEquation = if (onCurrentEquation.length > 1) {
            onCurrentEquation.substring(0, onCurrentEquation.length - 1)
        } else {
            ""
        }
        calculateOutcome()
        updateEquation()
        updateOutcome()

    }

    fun solve() {

        if (onCurrentOutcome.isNotEmpty()) {
            onCurrentEquation = onCurrentOutcome
            onCurrentOutcome = ""
        }

        updateOutcome()
        updateEquation()
    }

    fun clear() {
        onCurrentOutcome = ""
        onCurrentEquation = ""
        updateEquation()
        updateOutcome()
    }

    private fun calculateOutcome() {
        if (onCurrentEquation.isNotEmpty()) {

            try {
                onIterpreter.eval("result = $onCurrentEquation")
                val result = onIterpreter.get("result")
                if ((result != null && result is Int) || (result != null && result is Double) || (result != null && result is Float)) {
                    onCurrentOutcome = String.format("%.1f", result.toString().toDouble())
                }
            } catch (e: Exception) {
                onCurrentOutcome = ""
            }
        } else {
            onCurrentOutcome = ""
        }

    }

    private fun updateEquation() {
        onView?.setEquation(onCurrentEquation)
    }

    private fun updateOutcome() {
        onView?.setOutcome(onCurrentOutcome)
    }


    fun getCalculationData():CalculationData{
        var calculationData=CalculationData()
        if(onCurrentEquation!=""|| onCurrentOutcome!=""){
            calculationData =CalculationData(0,System.currentTimeMillis(), onCurrentEquation, onCurrentOutcome)
        }
        return calculationData
    }


}