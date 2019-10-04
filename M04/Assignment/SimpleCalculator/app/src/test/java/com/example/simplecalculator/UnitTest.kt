package com.example.simplecalculator

import org.junit.Test
import org.mockito.Mockito.`when`
import kotlin.test.assertEquals
import org.mockito.Mockito
import org.mockito.Mockito.mock

class UnitTest{

    private val calculator = mock(Calculator::class.java)

    @Test
    fun num(){


        val nums = listOf("9","-", "1")

        val expected = 1

        `when`(calculator.calculate(nums)).thenReturn(expected)

        val n = calculator.calculate(nums)

        assertEquals(expected, n)

    }
}