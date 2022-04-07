package com.example.noteapp.model

import com.google.gson.annotations.SerializedName

data class Note(

    @SerializedName("header")
    val header:String,
    @SerializedName("content")
    val content:String


)
