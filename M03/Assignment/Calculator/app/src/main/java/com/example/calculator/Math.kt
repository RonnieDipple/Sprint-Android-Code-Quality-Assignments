package com.example.calculator

import kotlin.math.absoluteValue

class Math {

    fun sumSquaresOfTwo(num1: Int, num2: Int): Int{


       return (num1 * num1) + (num2 * num2)
    }

    fun numDifAbs(num1: Int, num2: Int): Int{
       return (num1.absoluteValue - num2.absoluteValue) //never knew about the absolute function until I looked it up, note to self do that more often
    }

    fun factorial(int: Int): Int{/*This uses recursion also "So a factorial is just a number multiplied by all the integers below it
so a 5 factorial (denoted as 5!) is 5 * 4 * 3 * 2 * 1" -Tyler Clawson lol*/
        return if (int == 1) int else int*factorial(int - 1)
    }

    //Checks if number is a prime number

    fun isPrime(num1: Int): Boolean{

        for (i in 2..num1 / 2){
            if(num1 % i == 0){
                return false
            }
        }

        return true
    }
    
}