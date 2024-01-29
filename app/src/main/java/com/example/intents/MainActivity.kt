package com.example.intents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    lateinit var name: EditText
    lateinit var age: EditText
    lateinit var send: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        name = findViewById(R.id.editTextName)
        age = findViewById(R.id.editTextNumber)
        send = findViewById(R.id.buttonSend)

        send.setOnClickListener {

            //take note that the user could either write something or nothing
            //so we use this code instead in that case:
            var userName : String = name.text.toString()
            if(userName.isEmpty()){
                userName = "BLANK"
            }
            var userAge : Int ?= age.text.toString().toIntOrNull()

            //the intent takes two parameters ; the activity which launches the intent
            //and the activity which it carries the intent to...in this case the SecondActivity
            var intent = Intent(this@MainActivity, SecondActivity::class.java)

            //to carry along data from one activity to another
            intent.putExtra("username",userName)
            intent.putExtra("userage", userAge)

            startActivity(intent) //to start the intent after creating the intent object


            //don't forget to update the manifest file to specify that the MainActivity is the parentActivity
            //else the navigation button doesn't show up and the app crashes after the intent

        }

    }
}