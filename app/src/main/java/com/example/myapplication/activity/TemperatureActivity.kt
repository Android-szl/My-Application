package com.example.myapplication.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityTemperatureBinding
import com.example.myapplication.utils.TempSensorType
import com.example.myapplication.viewModel.TemperatureViewModel

class TemperatureActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityTemperatureBinding>(
            this,
            R.layout.activity_temperature
        )
        //创建ViewModel
        val viewModel = ViewModelProvider(this).get(TemperatureViewModel::class.java)
        //观察ViewModel里的数据变化
        viewModel.apply {
            val that = this@TemperatureActivity
            supportTest.observe(that, Observer {
                //观察传感器支持类型
                when (it) {
                    TempSensorType.BODY_ENV_TEMP -> {
                        //支持环境温度和体温的测试
                        if (!binding.bodyAndEnvView.isInflated) {
                            binding.bodyAndEnvView.viewStub?.inflate()
                        }
                    }
                    TempSensorType.BODY_TEMP -> {
                        //支持体温的测试
                        if (!binding.bodyTempView.isInflated) {
                            binding.bodyTempView.viewStub?.inflate()
                        }
                    }
                    TempSensorType.NONE -> {
                        //不支持温度测试
                        if (!binding.noSupportView.isInflated) {
                            binding.noSupportView.viewStub?.inflate()
                        }
                    }
                }
            })
            bodyTempValue.observe(that, Observer {
                binding.bodyTempValue = it
            })
            envTempValue.observe(that, Observer {
                binding.envTempValue = it
            })
        }
    }
}