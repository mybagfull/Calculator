package com.denishrynkevich.calculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {
    private val _displayValue = MutableLiveData<String>()
    val displayValue: LiveData<String> = _displayValue

    init {
        _displayValue.value = "0"
    }

    fun onDigitClick(digit: String) {
        //TODO
    }

    fun onDotClick() {
        //TODO
    }

    fun onOperatorClick(op: String) {
        //TODO
    }

    fun onEqualsClick() {
        //TODO
    }

    fun onClearClick() {
        //TODO
    }

    fun onChangeSign() {
        //TODO
    }

}