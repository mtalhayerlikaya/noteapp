package com.example.noteapp.Api

import com.example.noteapp.model.LoginRequest
import com.example.noteapp.model.LoginResponse
import com.example.noteapp.model.NoteRequest
import com.example.noteapp.model.NoteResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface RetrofitApi {
    @Headers("Content-Type: application/json")
    @POST("login")
    suspend fun sendLoginReq(@Body body: LoginRequest):Response<LoginResponse>

    @Headers("Content-Type: application/json")
    @POST("notes")
    suspend fun getNotes(@Body body: NoteRequest):Response<NoteResponse>



}