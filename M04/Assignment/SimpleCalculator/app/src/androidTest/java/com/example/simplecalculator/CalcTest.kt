package com.example.simplecalculator

import org.junit.Test
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule

class CalcTest {

   companion object{
       const val NUMBER = "9"
   }

    @Rule// junit test rule
    @JvmField// allows for compatibility with Kotlin


    var activityScenarioRule
            = ActivityScenarioRule(MainActivity::class.java)//Creates and launches the activity for testing
    @Test
    fun shouldAdd9ToUI() {

        onView(withId(R.id.button_nine))
            .perform(click())

        onView(withId(R.id.numberDisp)).check(matches(withText(NUMBER)))


    }


}