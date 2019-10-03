package com.example.calculator

class Calculator(private val math: Math) {

    fun factorial(int: Int): Int{

        return math.factorial(int)

    }

    fun difference(num1: Int, num2: Int): Int{
        return math.numDifAbs(num1, num2)

    }
    
    fun prime(num1: Int): Boolean{
        return math.isPrime(num1)
    }



}