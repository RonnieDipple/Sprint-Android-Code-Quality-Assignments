package com.example.guidedcalculator

class Utilities(private val validator: Validator) {
    fun checkIfStringIsPalindrome(original: String): Boolean {
        return validator.isStringPalindrome(original)
    }
}