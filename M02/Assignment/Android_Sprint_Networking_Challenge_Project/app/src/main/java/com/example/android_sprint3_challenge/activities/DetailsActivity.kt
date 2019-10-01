package com.example.android_sprint3_challenge.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.android_sprint3_challenge.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_details.*


class DetailsActivity : AppCompatActivity()/*, Callback<Pokemon> */{
    lateinit var myText: String
   /* override fun onFailure(call: Call<Pokemon>, t: Throwable) {
        t.printStackTrace()
        val response = "Failure: ${t.printStackTrace()}"
        Toast.makeText(this, response, Toast.LENGTH_SHORT).show()
    }

    override fun onResponse(call: Call<Pokemon>, response: Response<Pokemon>) {
        val myPokemon: Pokemon? = response.body()
        for (i in 0 until myPokemon?.types?.lastIndex!!.toInt()){
            myText = myPokemon?.id.toString()

        }


    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val id = intent.getStringExtra("id")
        val url = intent.getStringExtra("spriteUrl")
        val name = intent.getStringExtra("name")
        val ability = intent.getStringArrayListExtra("ability")
        val move = intent.getStringArrayListExtra("move")
        val type = intent.getStringArrayListExtra("type")


        if (id != null && url != null){
            Picasso.get().load(url).into(image_view_fullscreen)
            text_view_no_id.text = id
            text_view_name.text = name
            //text_view_ability.text = ability
        }else{

            val response = "Failure"
            Toast.makeText(this, response, Toast.LENGTH_SHORT).show()

        }


    }
}
