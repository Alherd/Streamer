package com.alherd.streamer.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast
import com.alherd.streamer.R
import com.alherd.streamer.usecases.UseCases
import com.google.firebase.database.DatabaseError

class MainActivity : AppCompatActivity(), UseCases.LoaderCameras {

    override fun camerasFailedToLoad(error: DatabaseError) {
        Toast.makeText(applicationContext, error.toString(), Toast.LENGTH_SHORT).show()
    }

    override fun camerasLoaded(list: List<Any>) {
        Toast.makeText(applicationContext, list.toString(), Toast.LENGTH_SHORT).show()
    }

    lateinit var buttonSave: Button
    val useCases = UseCases()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonSave = findViewById(R.id.hello_button)

        useCases.registerCallBack(this)

        buttonSave.setOnClickListener {
            loadCameras()
        }
    }

    private fun loadCameras() {
        useCases.getListFromFireBase("cameras")
    }

}
