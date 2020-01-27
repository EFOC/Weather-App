package com.example.weatherapp.Model

import com.google.gson.annotations.SerializedName

class Post {

    @SerializedName("name")
    lateinit var location: String

    @SerializedName("main")
    lateinit var mainInfo: MainInfo

    @SerializedName("cod")
    lateinit var code: Integer
}