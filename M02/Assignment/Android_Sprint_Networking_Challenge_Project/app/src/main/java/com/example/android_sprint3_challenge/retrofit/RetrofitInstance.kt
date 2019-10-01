package com.example.android_sprint3_challenge.retrofit

import com.example.android_sprint3_challenge.api.PokemonApiInterface
import com.example.android_sprint3_challenge.model.Pokemon
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitInstance {
    private const val BASE_URL = "https://pokeapi.co/api/v2/pokemon/"

    fun getPokemon(pokemon: String): Call<Pokemon>{
        val gson = GsonBuilder()
            .setLenient()
            .create()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        return retrofit.create(PokemonApiInterface::class.java).getPokemonApiFun(pokemon)
    }
}