package com.example.weatherapp

import com.example.weatherapp.Model.Post
import retrofit2.Call
import retrofit2.http.GET

interface JsonWeatherApi {

    @GET("data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22")
    fun getPosts(): Call<Post>
}