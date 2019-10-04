package com.example.helloespresso.util

import android.text.TextUtils
import android.util.Patterns
import java.util.regex.Pattern

object Validator {

    fun isEmailValid(target: CharSequence): Boolean {
        //Constants
        return !TextUtils.isEmpty(target) && //checking to see if it is not empty
                Patterns.EMAIL_ADDRESS.matcher(target).matches()//and checking to see if it matches this email address pattern
    }

    // REGEX PASSWORD Validation:
    // Ref: https://stackoverflow.com/questions/36574183/how-to-validate-password-field-in-android
    private val PASSWORD_PATTERN: Pattern =
        Pattern.compile("^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$")

    fun isPasswordValid(target: CharSequence): Boolean{
        return !TextUtils.isEmpty(target) && PASSWORD_PATTERN.matcher(target).matches()
    }


}