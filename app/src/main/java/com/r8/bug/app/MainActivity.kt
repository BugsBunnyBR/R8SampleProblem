package com.r8.bug.app

import android.os.Bundle
import android.widget.TextView
import androidx.annotation.Keep
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val data = MyData.fromJson(
            """
            {
            name: "julio",
            age: 18
            }
        """.trimIndent()
        )
        findViewById<TextView>(R.id.text).text = data.toString()
    }
}

data class MyData(
    @SerializedName("name")
    val name: String,
    @SerializedName("age")
    val age: Int
) {

    companion object {
        fun fromJson(json: String): MyData {
            return Gson().fromJson(json, MyData::class.java)
        }
    }
}
