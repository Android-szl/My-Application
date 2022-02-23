package com.example.myapplication.fragment

import android.graphics.Rect
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.adapter.OnSellListAdapter
import com.example.myapplication.databinding.FragmentOnSellBinding
import com.example.myapplication.base.BaseVMFragment
import com.example.myapplication.utils.SizeUtils
import com.example.myapplication.viewModel.OnSellViewModel

open class OnSellFragment : BaseVMFragment<FragmentOnSellBinding, OnSellViewModel>() {
    override fun getSubVMClass(): Class<OnSellViewModel> {
        return OnSellViewModel::class.java
    }

    override fun startLoadData() {
        //加载数据
        viewModel.loadData()
    }

    override fun observerData() {
        //观察ViewModel里的数据变化
        viewModel.loadState.observe(this, Observer { newState ->
            println("newState-->$newState")
            //更新UI
            //TODO
        })
        viewModel.contentList.observe(this, Observer { contentList ->
            println("contentList size --> ${contentList.size}")
            //当我们的内容列表发生变化的时候，就会调用到这个方法
            //更新列表
            mAdapter.setData(contentList)
        })
    }

    private val mAdapter by lazy {
        OnSellListAdapter()
    }


    override fun initView() {
        binding.onSellList.run {
            //布局管理器
            layoutManager = LinearLayoutManager(context)
            //设置适配器
            adapter = mAdapter
            //设置间距
            addItemDecoration(object : RecyclerView.ItemDecoration() {
                override fun getItemOffsets(
                    outRect: Rect, view: View,
                    parent: RecyclerView, state: RecyclerView.State
                ) {
                    //单位是px，不适配 5dp-->px
                    outRect.bottom = SizeUtils.dip2px(requireContext(), 5.0f)
                    outRect.left = SizeUtils.dip2px(requireContext(), 5.0f)
                    outRect.right = SizeUtils.dip2px(requireContext(), 5.0f)
                }
            })

        }

    }


    override fun getSubLayoutId(): Int {
        return R.layout.fragment_on_sell
    }

}