package com.example.calculator

sealed class CalculatorOnAction {
    data class Number (val number: Int): CalculatorOnAction()
    object Clear: CalculatorOnAction()
    object Delete: CalculatorOnAction()
    object Decimal: CalculatorOnAction()
    object Calculate: CalculatorOnAction()
    object DoubleZero: CalculatorOnAction()
    data class Operation(val operation: CalculatorOperation): CalculatorOnAction()
}
