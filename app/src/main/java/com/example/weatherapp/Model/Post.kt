package com.example.weatherapp.Model

import com.google.gson.annotations.SerializedName

class Post {

    @SerializedName("name")
    lateinit var location: String

    lateinit var mainInfo: MainInfo
}