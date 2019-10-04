package com.example.helloespresso

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.FixMethodOrder
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters
import java.util.regex.Pattern

@RunWith(AndroidJUnit4::class)
@LargeTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

class ValidationTests: UITestBase() {

@Rule
@JvmField
var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun changeEditText_validEmails(){//Email checker

        //setup
        val validEmails = listOf(
            "Test@email.com",
            "valid@gmail.com"
        )

        validEmails.forEach { email->
            onView(withId(R.id.email_input)).perform(

                *commonViewAction(email)

            )

        }

        // perform

        // check
        onView(withId(R.id.check_email_box)).check(matches(isChecked()))

    }



    @Test
    fun changeEditText_invalidEmails(){//Email checker

        //setup
        val invalidEmails = listOf(
            "Test@email.",
            "validgmail.com"
        )

        invalidEmails.forEach { email->
            onView(withId(R.id.email_input)).perform(

                *commonViewAction(email)

            )

        }

        // perform

        // check
        onView(withId(R.id.check_email_box)).check(matches(isNotChecked()))

    }


    @Test
    fun changedEditText_validPasswords(){
        //setup
        val validPasswords = listOf(
            "Adj$2k-29!",
            "029njnJhj3bj-JKJ$()"
        )

        //execute
        validPasswords.forEach {
            onView(withId(R.id.password_input)).perform(
                *commonViewAction(it)
            )
        }

        //check

        onView(withId(R.id.check_password_box)).check(matches(isChecked()))




    }


}