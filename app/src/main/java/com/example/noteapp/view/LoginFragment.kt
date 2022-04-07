package com.example.noteapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.noteapp.R
import com.example.noteapp.databinding.FragmentLoginBinding
import com.example.noteapp.model.LoginRequest
import com.example.noteapp.util.Constants
import com.example.noteapp.viewmodel.LoginViewModel


class LoginFragment : Fragment() {

    private lateinit var binding:FragmentLoginBinding
    private lateinit var viewModel:LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_login,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(LoginViewModel::class.java)

        binding.loginButton.setOnClickListener {
            val username = binding.usernameText.text.toString()
            val password = binding.passwordText.text.toString()
            val loginReq = LoginRequest(username,password)
            viewModel.loadLiveData(loginReq)
        }

        registerToObserver()
    }

    fun registerToObserver(){
        viewModel.loginResponse.observe(viewLifecycleOwner, Observer {
            when(it?.status){
                "SUCCESS"->{
                    println(it)
                    //println("login succesful")
                }
                else->{
                    println("failed")
                }
            }
        })
    }


}