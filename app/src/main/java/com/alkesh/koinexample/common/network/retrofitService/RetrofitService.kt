package com.alkesh.koinexample.common.network.retrofitService

import com.alkesh.koinexample.common.constant.AppConstants
import com.alkesh.koinexample.common.network.ApiService
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class RetrofitService(private val appConstants: AppConstants) {
    private lateinit var retrofit: Retrofit

    fun getInstance(): ApiService {
        val retrofit = getRetrofitInstance()
        return retrofit.create(ApiService::class.java)
    }

    private fun getRetrofitInstance(): Retrofit {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        val clientBuilder = OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(90, TimeUnit.SECONDS)
            .readTimeout(90, TimeUnit.SECONDS)
            .addInterceptor(interceptor)

        val client = clientBuilder.build()
        val builder = Retrofit.Builder()
        builder.baseUrl(appConstants.BaseURL)
        builder.addConverterFactory(
            GsonConverterFactory.create(
                GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
            )
        )
        builder.client(client)
        retrofit = builder.build()
        return retrofit
    }

}