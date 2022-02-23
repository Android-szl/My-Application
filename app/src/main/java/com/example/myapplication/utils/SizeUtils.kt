package com.example.myapplication.utils

import android.content.Context

object SizeUtils {
    fun dip2px(context: Context, dpValues: Float): Int {
        val scale: Float = context.resources.displayMetrics.density
        return (dpValues * scale + 0.5f).toInt()
    }
}