package com.example.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        updateUI("")
    }

    //The two lists will grow and shrink depending on the users input, they are dynamic
    val operationList: MutableList<String> = arrayListOf()
    val numCache: MutableList<String> = arrayListOf()

    private fun extractString(items: List<String>, connect: String = ""): String{
        if(items.isEmpty()) return "" //will return nothing if empty

        //https://dev.to/lalunamel/how-efficient-list-operators-work-in-kotlin-4o3d
        return items.reduce{acc, s-> acc + connect + s}

    }

    private fun updateUI(mainUIString: String){
        //
        val calculationString = extractString(operationList, "")
        var calculationTextView = numberDisp as TextView //My text view
        calculationTextView.text = calculationString

        val ans = display as TextView
        ans.text = mainUIString

    }

    private fun num(view: View){
        val button = view as Button
        val numString = button.text

        numCache.add(numString.toString())
        val text = extractString(numCache)
        updateUI(text)
    }

    private fun operator(view: View){
        val button = view as Button
        if(numCache.isEmpty()) return
        operationList.add(extractString(numCache))
        numCache.clear()
        operationList.add(button.text.toString())
        updateUI(button.text.toString())
    }

    private fun clearCache(){
        operationList.clear()
        numCache.clear()
    }

    private fun allClear(view: View){
        clearCache()
        updateUI("")
    }

    private fun equal(view: View){
        operationList.add(extractString(numCache))
        numCache.clear()

        val calc = Calculator()
        val answer = calc.calculate(operationList)

        updateUI("=" + answer.toString())
        clearCache()
    }


}
