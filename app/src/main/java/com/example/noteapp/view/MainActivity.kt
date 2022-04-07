package com.example.noteapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.noteapp.Api.RetrofitApi
import com.example.noteapp.R
import com.example.noteapp.model.LoginRequest
import com.example.noteapp.model.NoteRequest
import com.example.noteapp.repo.LoginRepository
import com.example.noteapp.util.Constants
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val scope = CoroutineScope(Job() + Dispatchers.IO)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println("deneme")


        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitApi::class.java)

        val login = LoginRequest("enes", "143223")
        val note = NoteRequest("SADWAFSFW432423DSA")

        scope.launch {
            val response = retrofit.sendLoginReq(login)
           // println(response)
            if (response.isSuccessful) {
                response.body()?.let {
                   // println(response.body())
                   // println(it.token)
                }
            }
        }

        scope.launch {
            val response = retrofit.getNotes(note)
            //println(response)
            if (response.isSuccessful) {
                response.body()?.let {
                    //println(response.body())
                    //println(it.notes)
                }
            }


        }


    }


}