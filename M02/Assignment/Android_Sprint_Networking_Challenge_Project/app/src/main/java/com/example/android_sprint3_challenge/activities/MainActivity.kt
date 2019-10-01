package com.example.android_sprint3_challenge.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.widget.Adapter
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_sprint3_challenge.R
import com.example.android_sprint3_challenge.retrofit.RetrofitInstance
import com.example.android_sprint3_challenge.model.Pokemon
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var linearLayoutManager: LinearLayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val progressBar = progress_bar
        val context = this

        linearLayoutManager = LinearLayoutManager(this)
        recycler_view.layoutManager = linearLayoutManager


        image_View_Search_icon.setOnClickListener {


            RetrofitInstance.getPokemon(edit_Text_Search.text.toString())
                .enqueue(object : Callback<Pokemon> {
                    override fun onFailure(call: Call<Pokemon>, t: Throwable) {
                        t.printStackTrace()
                        val response = "Failure: ${t.printStackTrace()}"
                        Toast.makeText(context, response, Toast.LENGTH_SHORT).show()
                    }

                    override fun onResponse(call: Call<Pokemon>, response: Response<Pokemon>) {
                        if (response.code() == 200 || response.code() == 201) {
                            toggleVisibility(progressBar)
                            val myPokemon: Pokemon? = response.body() // The Json response body
                            val intent = Intent(context, DetailsActivity::class.java)
                            intent.putExtra(
                                "id",
                                myPokemon?.id.toString()
                            ) // passes the id from the json body into the intent
                            intent.putExtra(
                                "spriteUrl",
                                myPokemon?.sprites?.front_default
                            ) // passes the URL from the json body into the intent
                            intent.putExtra("name", myPokemon?.name.toString())
                            val main = cons_layout
                            val view = layoutInflater.inflate(R.layout.list_item, main, false)
                            main.addView(view)


                            /* intent.putExtra("ability", myPokemon?.abilities)
                             intent.putExtra("move", myPokemon?.move)
                             intent.putExtra("type", myPokemon?.types)*/



                            startActivity(intent) // Starts the activity with the intent


                        }
                    }
                })
            toggleVisibility(progressBar)


        }


    }

    //makes views visible or invisible

    fun toggleVisibility(view: View) {

        view.visibility = if (view.visibility == View.VISIBLE) {
            View.INVISIBLE
        } else {
            View.VISIBLE
        }


    }
}
