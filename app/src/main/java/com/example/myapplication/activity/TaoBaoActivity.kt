package com.example.myapplication.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import com.example.myapplication.fragment.OnSellFragment

class TaoBaoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tao_bao)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, OnSellFragment())
            .commit()
        //孙培翔
    }
}