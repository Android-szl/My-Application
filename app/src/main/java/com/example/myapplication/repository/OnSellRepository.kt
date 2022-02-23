package com.example.myapplication.repository

import com.example.myapplication.domain.OnSellResult
import com.example.myapplication.domain.ResultData
import com.example.myapplication.net.RetrofitClient

class OnSellRepository {

    suspend fun getOnSellListByPage(page: Int): ResultData<OnSellResult> = RetrofitClient.apiService.getOnSellList(page)
}