package com.example.noteapp.model

import com.google.gson.annotations.SerializedName

data class LoginResponse(

    @SerializedName("token")
    val token:String,
    @SerializedName("status")
    val status:String


)
