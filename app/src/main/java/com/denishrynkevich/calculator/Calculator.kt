package com.denishrynkevich.calculator

class Calculator {
    var currentInput: String = ""
    var buffInput: String = "0"
    var previousInput: String = ""
    var operationToCalc: String? = null
    var result: Double = 0.0

    fun appendDigit(digit: String) {
        if (buffInput == "0" && digit != ".") {
            buffInput = digit
        } else if (digit == "." && buffInput.contains(".")) {
            return
        } else {
            buffInput += digit
        }
    }

    fun inputHandleOp(op: String) {
        if (buffInput.isNotEmpty()) {
            if (previousInput.isNotEmpty()) {
                calculate()
                previousInput = result.toString()
            } else {
                previousInput = buffInput
            }
            operationToCalc = op
            buffInput = ""
        }
    }

    fun clearCalculate() {
        previousInput = ""
        operationToCalc = null
    }

    fun calculate() {
        if (previousInput.isEmpty() || buffInput.isEmpty() || operationToCalc == null) {
            return
        }
        val num1 = previousInput.toDoubleOrNull() ?: 0.0
        val num2 = buffInput.toDoubleOrNull() ?: 0.0

        result = when (operationToCalc) {
            "+" -> num1 + num2
            "-" -> num1 - num2
            "x" -> num1 * num2
            "/" -> if (num2 != 0.0) num1 / num2 else Double.NaN // Handle division by zero
            else -> num2
        }
        currentInput = if (result.isNaN()) "Error" else result.toString()
    }

    fun clear() {
        currentInput = ""
        buffInput = ""
        previousInput = ""
        operationToCalc = null
        result = 0.0
    }

    fun calculatePercent() {
        if (buffInput.isNotEmpty()) {
            val num = buffInput.toDoubleOrNull() ?: 0.0
            buffInput = (num / 100).toString()
        }
    }

    fun changeSign() {
        if (buffInput.isNotEmpty()) {
            try {
                val num = buffInput.toDouble()
                buffInput = (-num).toString()
            } catch (e: NumberFormatException) {
                buffInput = "Error"
            }
        }
    }
}