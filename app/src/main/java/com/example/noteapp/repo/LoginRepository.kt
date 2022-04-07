package com.example.noteapp.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.noteapp.Api.RetrofitApi
import com.example.noteapp.model.LoginRequest
import com.example.noteapp.model.LoginResponse
import com.example.noteapp.util.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class LoginRepository
@Inject
constructor(val api:RetrofitApi) {

    private var loginRepoResponse = MutableLiveData<LoginResponse?>()

    fun returnLiveData():MutableLiveData<LoginResponse?>{
        return loginRepoResponse
    }

    suspend fun sendLoginRequest(loginReq:LoginRequest){
        val response = api.sendLoginReq(loginReq)
        println(response)
        if(response.isSuccessful){
            response.body()?.let {
                //println(it)
                loginRepoResponse.value = it
            }
        }
    }


}