package com.example.helloespresso

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.FixMethodOrder
import org.junit.Ignore
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters
import kotlin.reflect.typeOf


@RunWith(AndroidJUnit4::class)
@LargeTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING) //Sorts when testing will happen so it happens in a specific order
class TitleUITest : UITestBase (){
    companion object{
        const val  TITLE_TEXT = "This is my test title"
    }

    @Rule// junit test rule
    @JvmField// allows for compatibility with Kotlin


    var activityScenarioRule
            = ActivityScenarioRule(MainActivity::class.java)//Creates and launches the activity for testing

    @Test
    fun a_changeTitle_sameActivity(){
        //setup


        onView(withId(R.id.title_input))//Adds titleText to the title
            .perform(typeText(TITLE_TEXT), closeSoftKeyboard()) //close soft keyboard just closes the keyboard on screen, watch your imports

        //execute
        onView(withId(R.id.change_title_button)).perform(click())//Clicks the button view

        //check

        onView(withId(R.id.title_view)).check(matches(withText(TITLE_TEXT)))//Checks that it matches
        viewPressBack()


    }

    @Test
    fun b_changeTitle_newActivity(){

        //setup
        onView(withId(R.id.title_input))
            .perform(typeText(TITLE_TEXT), closeSoftKeyboard())


        //execute
        onView(withId(R.id.pass_title_button)).perform(click())


        //check
        onView(withId(R.id.show_title_view)).check(matches(withText(TITLE_TEXT)))
       viewPressBack()

        //onView(withId(R.id.title_view)).check(matches(withText(TITLE_TEXT)))

    }

    @Ignore("Skip this test for now")//this notifies studio to skip the following test, very handy
    @Test
    fun anotherTest(){
        onView(withId(R.id.title_input)).perform(clearText(), typeText(TITLE_TEXT))
    }



}