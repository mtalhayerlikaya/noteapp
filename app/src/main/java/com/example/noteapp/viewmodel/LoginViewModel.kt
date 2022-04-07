package com.example.noteapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteapp.model.LoginRequest
import com.example.noteapp.model.LoginResponse
import com.example.noteapp.repo.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel
@Inject
constructor(val repo:LoginRepository): ViewModel() {

    private var loginResponse_ = MutableLiveData<LoginResponse?>()
    val loginResponse:LiveData<LoginResponse?>
        get() = loginResponse_

    init {
        loginResponse_ = repo.returnLiveData()
    }

    fun loadLiveData(loginReq:LoginRequest)=viewModelScope.launch{
        repo.sendLoginRequest(loginReq)
    }
    fun clearLiveData(){
        loginResponse_.value = null
    }

}