package com.alkesh.koinexample.core.repository

import com.alkesh.koinexample.common.base.repo.BaseRepository
import com.alkesh.koinexample.common.network.ApiService
import com.alkesh.koinexample.core.models.response.MyTaskApiResponse


class TaskRepository(private val apiService: ApiService) : BaseRepository() {


    suspend fun getMyTasks(): MyTaskApiResponse? {
        var response: MyTaskApiResponse? = null
        val result = apiService.getMyTask()
        if (result.isSuccessful) {
            response = result.body()
        }
        return response
    }

}