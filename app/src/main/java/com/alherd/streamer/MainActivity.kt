package com.alherd.streamer

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


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
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("cameras").child("0").child("description")
        // Read from the database
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = dataSnapshot.getValue(String::class.java)
                Toast.makeText(applicationContext, value.toString(), Toast.LENGTH_SHORT).show()
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Toast.makeText(applicationContext, "failed", Toast.LENGTH_SHORT).show()
            }
        })

    }

}
