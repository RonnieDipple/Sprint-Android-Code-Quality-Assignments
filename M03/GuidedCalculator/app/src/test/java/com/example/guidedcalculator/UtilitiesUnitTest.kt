package com.lambdaschool.testingcalculator

import com.example.guidedcalculator.Utilities
import com.example.guidedcalculator.Validator
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class UtilitiesUInitTest {

    private val validator = mock(Validator::class.java)
    private val utilities = Utilities(validator)

    @Test
    fun utilityCallTest_Valid() {
        // Setup
        val string = "madam"
        `when`(validator.isStringPalindrome(string)).thenReturn(true)

        // Execute
        val result = utilities.checkIfStringIsPalindrome(string)

        // Check
        assert(result)
    }


    @Test
    fun utilityCallTest_Invalid() {
        // Setup
        val string = "windows"
        `when`(validator.isStringPalindrome(string)).thenReturn(false)

        // Execute
        val result = utilities.checkIfStringIsPalindrome(string)

        // Check
        assert(!result)
    }

    // Test Palidromes
    @Test
    fun palindromeCheck_Valid() {
        // Setup
        val string = "racecar"
        val validator = Validator()

        // Execute
        val result = validator.isStringPalindrome(string)

        // Check
        assert(result)
    }

    @Test
    fun palindromeCheck_FirstLastMatch() {
        // Setup
        val string = "lambdaschool"
        val validator = Validator()

        // Execute
        val result = validator.isStringPalindrome(string)

        // Check
        assert(!result)
    }

    @Test
    fun palindromeCheck_Invalid() {
        // Setup
        val string = "android"
        val validator = Validator()

        // Execute
        val result = validator.isStringPalindrome(string)

        // Check
        assert(!result)
    }

    @Test
    fun palindromeCheck_Spaces() {
        // Setup
        val string = "a man a plan a canal panama"
        val validator = Validator()

        // Execute
        val result = validator.isStringPalindrome(string)

        // Check
        assert(result)
    }

    @Test
    fun palindromeCheck_Capitals() {
        // Setup
        val string = "lEveL"
        val validator = Validator()

        // Execute
        val result = validator.isStringPalindrome(string)

        // Check
        assert(result)
    }


}