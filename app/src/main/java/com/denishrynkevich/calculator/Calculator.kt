package com.denishrynkevich.calculator

class Calculator {
    var currentInput: String = ""
    var previousInput: String = ""
    var operationToCalc: String? = null
    var result: Double = 0.0

    fun appendDigit(digit: String) {
        if (currentInput == "0" && digit != ".") {
            currentInput = digit
        } else if (digit == "." && currentInput.contains(".")) {
            return
        } else {
            currentInput += digit
        }
    }

    fun inputHandleOp(op: String) {
        if (currentInput.isNotEmpty()) {
            if (previousInput.isNotEmpty()) {
                calculate()
            }
            operationToCalc = op
            previousInput = currentInput
            currentInput = ""
        }
    }

    fun calculate() {
        if (previousInput.isEmpty() || currentInput.isEmpty() || operationToCalc == null) {
            return
        }
        val num1 = previousInput.toDoubleOrNull() ?: 0.0
        val num2 = currentInput.toDoubleOrNull() ?: 0.0

        result = when (operationToCalc) {
            "+" -> num1 + num2
            "-" -> num1 - num2
            "x" -> num1 * num2
            "/" -> if (num2 != 0.0) num1 / num2 else Double.NaN // Handle division by zero
            else -> num2
        }
        currentInput = if (result.isNaN()) "Error" else result.toString()
        previousInput = ""
        operationToCalc = null
    }

    fun clear() {
        currentInput = ""
        previousInput = ""
        operationToCalc = null
        result = 0.0
    }

    fun calculatePercent() {
        if (currentInput.isNotEmpty()) {
            val num = currentInput.toDoubleOrNull() ?: 0.0
            currentInput = (num / 100).toString()
        }
    }

    fun changeSign() {
        if (currentInput.isNotEmpty()) {
            try {
                val num = currentInput.toDouble()
                currentInput = (-num).toString()
            } catch (e: NumberFormatException) {
                currentInput = "Error"
            }
        }
    }
}