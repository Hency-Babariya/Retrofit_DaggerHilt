package com.example.myapplicationxml.retrofit

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiRequestInterceptor @Inject internal constructor(
    @ApplicationContext private val context: Context,
) :
    Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()

        request = request.newBuilder().addHeader("token_key", "tokenValue").build()

        return chain.proceed(request)
    }
}