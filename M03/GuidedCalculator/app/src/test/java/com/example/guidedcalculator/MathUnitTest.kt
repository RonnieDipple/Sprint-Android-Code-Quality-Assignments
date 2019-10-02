package com.example.guidedcalculator

import junit.framework.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class MathUnitTest {
    private val math = mock(Math::class.java)
    private val calculator = Calculator(math)

    @Test
    fun calculatorAddition() {
        // Setup
        val num1 = 10
        val num2 = 17
        val expected = 27

        `when`(math.addIntegers(num1, num2)).thenReturn(expected)

        // Execute
        val sum = calculator.add(num1, num2)

        // Check
        assertEquals(expected, sum)
    }

    @Test
    fun viewModelSummation() {
        // Setup
        val num1 = 0
        val num2 = 7
        val expected = 7

        val viewModel = CalculatorViewModel()
        /*viewModel.calculator = calculator
        `when`(math.addIntegers(num1, num2)).thenReturn(expected)*/
        val calculator = mock(Calculator::class.java)
        `when`(calculator.add(num1, num2)).thenReturn(expected)
        viewModel.calculator = calculator


        // Execute
        val sum = viewModel.summation(num1, num2)

        // Check
        assertEquals(expected, sum)
    }

    @Test
    fun testAddIntegers() {
        // Set up the conditions of the test
        val num1 = 1
        val num2 = 5
        val expected = 6
        val math = Math()

        // Execute the code under test
        val sum = math.addIntegers(num1, num2)

        // Make assertions on the result
        assertEquals(expected, sum)
    }

    @Test
    fun testMultiplyIntegers(){
        //the correct way to perform testing is above this function in the other function this is just for ease of understanding
        val math = Math()
        val multiply = math.multiplyIntegers(10, 5)
        assertEquals(50, multiply)//Asserts 10 * 5 will be 50 in the math function multiplyIntegers in the Math class
    }

    @Test
    fun testMultiplyIntegersB() {
        // Setup
        val num1 = 45
        val num2 = 79
        val expected = 3555
        val math = Math()

        // Execute
        val product = math.multiplyIntegers(num1, num2)

        // Check
        assertEquals(expected, product)
    }
}