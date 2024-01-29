package com.example.intents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    lateinit var result : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        result = findViewById(R.id.textView)

        //to take over the data sent from another activity
        //the get____Extra depends on the variable type I.e getStringExtra, getIntExtra, etc
        //take note that the id name in the "" should be exactly identical to the putExtra in the previous activity
        var userName: String = intent.getStringExtra("username").toString()
        var userAge : Int = intent.getIntExtra("userage",0)

        result.text = "Your name is $userName and your age is $userAge"
    }
}