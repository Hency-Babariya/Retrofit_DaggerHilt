package com.example.myapplicationxml.retrofit

import com.example.myapplicationxml.model.UserDetail
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("posts")
    suspend fun getUserDetails(): Response<List<UserDetail>>

}