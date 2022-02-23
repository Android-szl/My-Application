package com.example.myapplication.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.OnSell
import com.example.myapplication.repository.OnSellRepository
import com.example.myapplication.utils.LoadState
import kotlinx.coroutines.launch

class OnSellViewModel : ViewModel() {
    companion object {
        const val DEFAULT_PAGE = 1
    }

    private var mCurrentPage = DEFAULT_PAGE

    private val repository by lazy {
        OnSellRepository()
    }


    fun loadData() {
        //这个加载需要UI层转圈圈(loading)
        //更新状态
        loadState.value = LoadState.LOADING
        //加载第一页的数据
        loadDataByPage(mCurrentPage)
    }


    private fun loadDataByPage(page: Int) {
        //根据页码加载数据
        try {
            viewModelScope.launch {
                val result = repository.getOnSellListByPage(page)
                println("result code ==> ${result.code}")
                println("result message ==> ${result.message}")
                println("result size ==> ${result.data.tbk_dg_optimus_material_response.result_list.map_data.size}")
                //对数据进行判断，数据为空或网络请求出错
                val resultList = result.data.tbk_dg_optimus_material_response.result_list.map_data
                if (resultList.isEmpty()) {
                    loadState.value = LoadState.EMPTY
                } else {
                    loadState.value = LoadState.SUCCESS
                    //更新数据
                    contentList.value = resultList
                }
                //处理一下数据
                loadState.value = LoadState.SUCCESS
            }
        } catch (e: Exception) {
            loadState.value = LoadState.ERROR
        }
    }

    //所关心的数据
    //加载状态：loading，Success，Empty，Error，None
    val loadState by lazy {
        MutableLiveData<LoadState>()
    }

    //数据列表:contentList
    val contentList by lazy {
        MutableLiveData<MutableList<OnSell>>()
    }
}