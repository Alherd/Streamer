package com.alherd.streamer.usecases

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class UseCases {

    interface LoaderCameras {
        fun camerasLoaded(list: List<Any>)
        fun camerasFailedToLoad(error: DatabaseError)
    }

    lateinit var loaderCameras: LoaderCameras


    fun registerCallBack(loaderCameras: LoaderCameras) = apply {
        this.loaderCameras = loaderCameras
    }

    fun getListFromFireBase(title: String) {
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference(title)
        var list: ArrayList<Any>

        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                list = dataSnapshot.value as (ArrayList<Any>)
                loaderCameras.camerasLoaded(list)
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                loaderCameras.camerasFailedToLoad(error)
            }
        })
    }

}