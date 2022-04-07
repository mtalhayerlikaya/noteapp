package com.example.noteapp.model

import com.google.gson.annotations.SerializedName

data class NoteRequest(


    @SerializedName("token")
    val token:String


)