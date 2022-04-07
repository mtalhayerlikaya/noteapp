package com.example.noteapp.Api

import com.example.noteapp.BuildConfig
import okhttp3.*
import okhttp3.Interceptor

class MockInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        if (BuildConfig.DEBUG) {
            val uri = chain.request().url().uri().toString()
            val responseString = when {
                uri.endsWith("login") -> getListOfReposBeingStarredJson
                else -> ""
            }

            return chain.proceed(chain.request())
                .newBuilder()
                .code(200)
                .protocol(Protocol.HTTP_2)
                .message(responseString)
                .body(
                    ResponseBody.create(
                    MediaType.parse("application/json"),
                    responseString.toByteArray()))
                .addHeader("content-type", "application/json")
                .build()
        } else {
            //just to be on safe side.
            throw IllegalAccessError("MockInterceptor is only meant for Testing Purposes and " +
                    "bound to be used only with DEBUG mode")
        }
    }

}


const val getListOfReposBeingStarredJson = """
{"username":"deneme","password":"123123123"}
"""

/*const val getListOfReposBeingStarredJson = """
[{
    "token": "SADWAFSFW432423DSA",
    "status":"SUCCESS"
}]
"""*/

/*
const val getListOfReposBeingStarredJson = """
[{
	"id": 1296269,
	"node_id": "MDEwOlJlcG9zaXRvcnkxMjk2MjY5",
	"name": "Hello-World",
	"full_name": "octocat/Hello-World",
	"private": false,
	"html_url": "https://github.com/octocat/Hello-World",
	"description": "This your first repo!",
	"fork": false,
	"languages_url": "http://api.github.com/repos/octocat/Hello-World/languages",
	"stargazers_count": 80,
	"watchers_count": 80,
	"pushed_at": "2011-01-26T19:06:43Z",
	"created_at": "2011-01-26T19:01:12Z",
	"updated_at": "2011-01-26T19:14:43Z",
	"subscribers_count": 42
}]
"""*/
