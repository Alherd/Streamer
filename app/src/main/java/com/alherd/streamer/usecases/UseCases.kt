package com.alherd.streamer.usecases

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

fun getListFromFireBase(title: String): List<Any> {
    val database = FirebaseDatabase.getInstance()
    val myRef = database.getReference(title)
    var list: ArrayList<Any> = ArrayList<Any>()

    myRef.addValueEventListener(object : ValueEventListener {
        override fun onDataChange(dataSnapshot: DataSnapshot) {
            // This method is called once with the initial value and again
            // whenever data at this location is updated.
            list = dataSnapshot.value as (ArrayList<Any>)

        }

        override fun onCancelled(error: DatabaseError) {
            // Failed to read value
        }
    })

    return list

}