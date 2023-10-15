package com.example.myapplicationxml.view

import com.example.myapplicationxml.model.UserDetail
import com.example.myapplicationxml.retrofit.ApiService
import retrofit2.Response
import javax.inject.Inject

class NetworkRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getUserDetail(): Response<List<UserDetail>> {
        return apiService.getUserDetails()
    }
}