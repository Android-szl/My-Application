package com.example.myapplication.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.databinding.ItemOnSellBinding
import com.example.myapplication.domain.OnSell


class OnSellListAdapter : RecyclerView.Adapter<OnSellListAdapter.InnerHolder>() {

    companion object {
        @JvmStatic
        @BindingAdapter("goodsImage")
        fun setImage(iv: ImageView, goodsImage: String?) {
            //显示图片
            if (goodsImage != null) {
                Glide.with(iv.context).load("https:${goodsImage}").into(iv)
            } else {
                //设置默认加载失败的图
            }
        }
    }

    private val mContentList by lazy {
        mutableListOf<OnSell>()
    }

    class InnerHolder(itemView: View, val binding: ItemOnSellBinding) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InnerHolder {
        //这里面的内容不可以设置成成员变量，只能是局部变量
        val itemBinding = DataBindingUtil.inflate<ItemOnSellBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_on_sell, parent, false
        )
        itemBinding.originalPrice.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
        return InnerHolder(itemBinding.root, itemBinding)
    }

    override fun onBindViewHolder(holder: InnerHolder, position: Int) {
        //拿到对应的数据
        val itemData = mContentList[position]

        holder.binding.eventHandler = EventHandler()

        //绑定数据，我们向binding里设置数据
        //要有binding
        holder.binding.itemData = itemData//拿到对应item的数据
    }

    override fun getItemCount(): Int {
        return mContentList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(contentList: MutableList<OnSell>) {
        //清空内容
        mContentList.clear()
        mContentList.addAll(contentList)
        //这里是全部更新了
        //如果是通过添加到头部，或者添加到底部的方式，可以局部更新
        notifyDataSetChanged()
    }

    inner class EventHandler() {
        fun onItemClick(itemData: OnSell) {
            println("onItem ...${itemData.title}")
        }

        fun onItemLongClick(itemData: OnSell): Boolean {
            println("123")
            return true
        }
    }

}