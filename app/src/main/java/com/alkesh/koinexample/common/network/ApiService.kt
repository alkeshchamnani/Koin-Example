package com.alkesh.koinexample.common.network

import com.alkesh.koinexample.core.models.response.MyTaskApiResponse
import retrofit2.Response
import retrofit2.http.POST


interface ApiService {

    @POST("v1/c185fc7e")
    suspend fun getMyTask(): Response<MyTaskApiResponse>

}