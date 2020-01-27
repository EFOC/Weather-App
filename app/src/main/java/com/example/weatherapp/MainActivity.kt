package com.example.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.weatherapp.Model.Post
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://samples.openweathermap.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val jsonWeatherApi: JsonWeatherApi = retrofit.create(JsonWeatherApi::class.java)
        val call: Call<Post> = jsonWeatherApi.getPosts()
        call.enqueue(object : Callback<Post> {
            override fun onFailure(call: Call<Post>?, t: Throwable?) {
                Log.d(TAG, "Error: " + t.toString())
            }

            override fun onResponse(call: Call<Post>?, response: Response<Post>?) {
                if (!response!!.isSuccessful) {
                    Log.d(TAG, "Code: " + response?.code().toString())
                }
                val post: Post = response.body()
                var message = "Location: " + post.location + "\n"
                message += "Code: " + post.code.toString() + "\n"
                message += "Humidity: " + post.mainInfo.humidity.toString() + "\n"
                message += "Temp: " + post.mainInfo.temp.toString() + "\n\n"
                Log.d(TAG, message)
                val textView: TextView = findViewById(R.id.main)
                textView.text = message

            }
        })
    }
}
