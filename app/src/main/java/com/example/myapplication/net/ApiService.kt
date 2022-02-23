package com.example.myapplication.net

import com.example.myapplication.domain.OnSellResult
import com.example.myapplication.domain.ResultData
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("onSell/{page}")
    suspend fun getOnSellList(@Path("page") page: Int): ResultData<OnSellResult>
}