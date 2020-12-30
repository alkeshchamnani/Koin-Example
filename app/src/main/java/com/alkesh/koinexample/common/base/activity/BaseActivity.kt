package com.alkesh.koinexample.common.base.activity

import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alkesh.koinexample.presentation.general.dialog.LoadingDialog


abstract class BaseActivity : AppCompatActivity() {
    var loadingDialog: LoadingDialog? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResId())
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
        init()
        setEvents()
        setObservers()
    }

    protected abstract fun init()

    protected abstract fun setEvents()

    protected abstract fun setObservers()

    protected abstract fun getLayoutResId(): Int

    fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    fun showLoadingDialog() {
        if (loadingDialog == null) {
            loadingDialog = LoadingDialog()
            loadingDialog?.let {
                it.isCancelable = false
                it.show(supportFragmentManager, LoadingDialog::class.java.name)
            }
        } else {
            loadingDialog?.apply {
                this.show(supportFragmentManager, LoadingDialog::class.java.name)
            }
        }
    }

    fun hideLoadingDialog() {
        loadingDialog?.dismiss()
    }

    fun bindAdapterWithRecyclerview(
        recyclerView: RecyclerView,
        adapter: RecyclerView.Adapter<*>?
    ) {
        val mLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = mLayoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                DividerItemDecoration.VERTICAL
            )
        )
        recyclerView.adapter = adapter
    }
}