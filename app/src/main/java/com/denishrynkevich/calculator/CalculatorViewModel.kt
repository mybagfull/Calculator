package com.denishrynkevich.calculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {
    private val calculator = Calculator()

    private val _displayValue = MutableLiveData<String>()
    val displayValue: LiveData<String> = _displayValue

    init {
        _displayValue.value = "0"
    }

    fun onDigitClick(digit: String) {
        calculator.appendDigit(digit)
        _displayValue.value = calculator.currentInput
    }


    fun onOperatorClick(op: String) {
        calculator.inputHandleOp(op)
        _displayValue.value = calculator.currentInput
    }

    fun onEqualsClick() {
        calculator.calculate()
        _displayValue.value= calculator.currentInput
    }

    fun onClearClick() {
        calculator.clear()
        _displayValue.value = "0"
    }

    fun onPlusMinusClick() {
        calculator.changeSign()
        _displayValue.value = calculator.currentInput
    }

    fun onPercentClick() {
        calculator.calculatePercent()
        _displayValue.value = calculator.currentInput
    }

}