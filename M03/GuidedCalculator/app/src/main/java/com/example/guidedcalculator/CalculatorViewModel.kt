package com.example.guidedcalculator

import androidx.lifecycle.ViewModel


//helpful for ui rotation etc
class CalculatorViewModel: ViewModel() {
    lateinit var calculator: Calculator

    fun summation(a: Int, b: Int): Int {
        return calculator.add(a, b)
    }
}