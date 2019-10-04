package com.example.simplecalculator

class Calculator {

    //Tried something new here hope it works
    fun calculate(calculationList: List<String>): Int {
        var currentOperation = ""
        var currentNumber = 0




        calculationList.forEach { token ->

            when {
                token.equals("+")
                        || token.equals("-")
                        || token.equals("X")
                        || token.equals("/") -> currentOperation = token


                currentOperation.equals("-") -> currentNumber -= token.toInt()
                currentOperation.equals("/") -> currentNumber /= token.toInt()
                currentOperation.equals("X") -> currentNumber *= token.toInt()


                else -> currentNumber += token.toInt()
            }


        }

        return currentNumber
    }


}