package com.alherd.streamer

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast
import com.alherd.streamer.usecases.getListFromFireBase


class MainActivity : AppCompatActivity() {

    lateinit var buttonSave: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonSave = findViewById(R.id.hello_button)

        buttonSave.setOnClickListener {
            saveHero()
        }
    }

    private fun saveHero() {
        Toast.makeText(applicationContext, getListFromFireBase("cameras").toString(), Toast.LENGTH_SHORT).show()
    }

}
