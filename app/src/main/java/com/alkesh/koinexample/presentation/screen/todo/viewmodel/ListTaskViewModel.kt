package com.alkesh.koinexample.presentation.screen.todo.viewmodel

import androidx.lifecycle.MutableLiveData
import com.alkesh.koinexample.common.base.viewmodel.BaseViewModel
import com.alkesh.koinexample.core.models.dto.TaskModel
import com.alkesh.koinexample.core.repository.TaskRepository
import kotlinx.coroutines.launch


class ListTaskViewModel(private val taskRepository: TaskRepository) : BaseViewModel() {
    val listTasks = MutableLiveData<ArrayList<TaskModel>>()

    fun getTasks() {
        isLoading.value = true
        coroutineScope.launch {
            val myTaskApiResponse = taskRepository.getMyTasks()
            isLoading.value = false
            myTaskApiResponse?.data?.let {
                listTasks.value = it
            } ?: run {}
        }
    }
}