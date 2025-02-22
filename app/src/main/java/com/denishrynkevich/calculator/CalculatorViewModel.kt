package com.denishrynkevich.calculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {
    private val calculator = Calculator()

    private val _inputValue = MutableLiveData<String>()
    val inputValue: LiveData<String> = _inputValue

    private val _displayValue = MutableLiveData<String>()
    val displayValue: LiveData<String> = _displayValue

    init {
        _displayValue.value = "0"
        _inputValue.value = ""
    }

    fun onDigitClick(digit: String) {
        calculator.appendDigit(digit)
        _inputValue.value += digit
        calculator.calculate()
        _displayValue.value = calculator.currentInput
    }


    fun onOperatorClick(op: String) {
        calculator.inputHandleOp(op)
        _displayValue.value = calculator.currentInput
        _inputValue.value += op
    }

    fun onEqualsClick() {
        calculator.calculate()
        calculator.clearCalculate()
        _displayValue.value = calculator.currentInput
        _inputValue.value = _displayValue.value
    }

    fun onClearClick() {
        calculator.clear()
        _displayValue.value = "0"
        _inputValue.value = ""
    }

    fun onPlusMinusClick() {
        calculator.changeSign()
        _displayValue.value = calculator.buffInput
    }

    fun onPercentClick() {
        calculator.calculatePercent()
        _displayValue.value = calculator.buffInput
    }

}