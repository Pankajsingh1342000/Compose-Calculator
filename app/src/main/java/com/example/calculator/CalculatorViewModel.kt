package com.example.calculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalculatorViewModel: ViewModel() {
    var state by mutableStateOf(CalculatorState())
        private set
    fun onAction (action: CalculatorOnAction) {
        when (action) {
            is CalculatorOnAction.Number -> enterNumber(action.number)
            is CalculatorOnAction.Decimal -> enterDecimal()
            is CalculatorOnAction.Delete -> performDelete()
            is CalculatorOnAction.Calculate -> performCalculation()
            is CalculatorOnAction.Clear -> state = CalculatorState()
            is CalculatorOnAction.Operation -> enterOperation(action.operation)
            is CalculatorOnAction.DoubleZero -> enterDoubleZero()
            else -> {}
        }

    }

    private fun enterDoubleZero() {
        state = state.copy(
            inputString = state.inputString + "00"
        )
        if(state.number1.isNotBlank() && state.number2.isBlank()){
            state = state.copy(
                number1 = state.number1 + "00"
            )
        }
        if(state.number2.isNotBlank()){
            state = state.copy(
                number2 = state.number2 + "00"
            )
        }
    }

    private fun enterOperation(operation: CalculatorOperation) {
        state = state.copy(
            inputString = state.inputString + (operation.symbol ?: "")
        )
        this.performCalculation()
        state = state.copy(
            operation = operation
        )
        if(state.number1.isNotBlank()){
            state = state.copy(
                operation = operation
            )
        }
    }


    private fun performCalculation() {
        val number1 = state.number1.toDoubleOrNull()
        val number2 = state.number2.toDoubleOrNull()

        if(number1 != null && number2 != null) {

            val result = when (state.operation) {
                is CalculatorOperation.Add -> number1 + number2
                is CalculatorOperation.Subtract -> number1 - number2
                is CalculatorOperation.Multiply -> number1 * number2
                is CalculatorOperation.Divide -> number1 / number2
                is CalculatorOperation.Modulus -> number1 % number2
                null -> return
                else -> {}
            }
            state = state.copy(
                result = result.toString(),
                number1 = result.toString(),
                number2 = "",
                operation = null
            )
        }
    }

    private fun performDelete() {
        state = state.copy(
            inputString = state.inputString.dropLast(1)
        )
        when {
            state.number2.isNotBlank() -> state = state.copy(
                number2 = state.number2.dropLast(1)
            )
            state.operation != null -> state = state.copy(
                operation = null
            )
            state.number1.isNotBlank() -> state = state.copy(
                number1 = state.number1.dropLast(1)
            )
        }
        performCalculation()
    }

    private fun enterDecimal() {
        state = state.copy(
            inputString = state.inputString + "."
        )
        if (state.operation == null && !state.number1.contains(".") && state.number1.isNotBlank()){
            state = state.copy(
                number1 = state.number1 + "."
            )
            return
        }
        if (!state.number2.contains(".") && state.number2.isNotBlank()) {
            state = state.copy(
                number2 = state.number2 + "."
            )
        }
    }

    private fun enterNumber(number: Int) {
        state = state.copy(
            inputString = state.inputString + number.toString()
        )
        if (state.operation == null) {
            if (state.number1.length >= MAX_NUM_LENGTH) {
                return
            }
            state = state.copy(

                number1 = state.number1 + number,
            )
            return
        }
        if(state.number2.length >= MAX_NUM_LENGTH){
            return
        }
        state = state.copy(
            number2 = state.number2 + number,
        )

    }

    companion object {
        private const val MAX_NUM_LENGTH = 8
    }
    
}