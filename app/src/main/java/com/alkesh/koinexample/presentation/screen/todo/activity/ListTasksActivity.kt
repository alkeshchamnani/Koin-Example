package com.alkesh.koinexample.presentation.screen.todo.activity

import androidx.lifecycle.Observer
import com.alkesh.koinexample.R
import com.alkesh.koinexample.common.base.activity.BaseActivity
import com.alkesh.koinexample.core.models.dto.TaskModel
import com.alkesh.koinexample.presentation.screen.todo.adapter.ListTaskAdapter
import com.alkesh.koinexample.presentation.screen.todo.viewmodel.ListTaskViewModel
import kotlinx.android.synthetic.main.activity_list_task.*
import org.koin.android.viewmodel.ext.android.getViewModel

class ListTasksActivity : BaseActivity() {
    private lateinit var viewModel: ListTaskViewModel
    private val listTask = ArrayList<TaskModel>()
    private var adapter = ListTaskAdapter(this, listTask);

    override fun init() {
        viewModel = getViewModel<ListTaskViewModel>()
        bindAdapterWithRecyclerview(recyclerViewer,adapter)
        viewModel.getTasks()

    }

    override fun setEvents() {
    }

    override fun setObservers() {
        viewModel.listTasks.observe(this, Observer {
            it?.let {
                listTask.clear()
                listTask.addAll(it)
                adapter.notifyDataSetChanged()
            }
        })
        viewModel.isLoading.observe(this, Observer {
            it?.let {
                if (it) {
                    showLoadingDialog()
                } else {
                    hideLoadingDialog()
                }
            }
        })
        viewModel.showMessage.observe(this, Observer {
            it?.let {
                showMessage(it)
            }
        })

    }

    override fun getLayoutResId(): Int {
        return R.layout.activity_list_task
    }
}