package com.example.calculator

import junit.framework.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class MathUnitTest {

    private val math = mock(Math::class.java)
    private val calculator = Calculator(math)


    @Test
    fun calculatorFactorialTest(){
        //setup
        val num1 = 7
        val expected = 5040

        `when`(math.factorial(num1)).thenReturn(expected)

        //execute
        val n = calculator.factorial(num1)

        //check
        assertEquals(expected, n)
    }


    @Test
    fun calculatorDifTest (){
        //setup
        val num1 = 20
        val num2 = 10
        val expected = 10
        /*
        val calc = Calculator(math)

        val n = calc.difference(num1, num2)*/

        `when`(math.numDifAbs(num1, num2)).thenReturn(expected)

        //execute
        val n = calculator.difference(num1, num2)

        assertEquals(expected, n)


    }





}