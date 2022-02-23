package com.example.myapplication.base

import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * 还不知道具体的布局和Binding
 */
abstract class BaseVMFragment<T : ViewDataBinding, VM : ViewModel> : BaseViewFragment<T>() {

    lateinit var viewModel: VM

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //创建ViewModel
        initViewModel()
        //观察数据变化-->更新UI
        observerData()
        //初始化相关控件
        initView()
        //设置相关的事件
        initEvent()
        //开始去加载数据
        startLoadData()
    }

    open fun initView() {

    }

    open fun startLoadData() {

    }

    open fun initEvent() {

    }

    open fun observerData() {

    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(getSubVMClass())
    }

    abstract fun getSubVMClass(): Class<VM>


}