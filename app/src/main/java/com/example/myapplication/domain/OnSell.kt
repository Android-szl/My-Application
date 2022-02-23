package com.example.myapplication.domain

data class OnSell(
    val category_id: Long,
    val category_name: Any,
    val click_url: String,
    val commission_rate: String,
    val coupon_amount: Long,
    val coupon_click_url: String,
    val coupon_end_time: String,
    val coupon_info: Any,
    val coupon_remain_count: Long,
    val coupon_share_url: String,
    val coupon_start_fee: String,
    val coupon_start_time: String,
    val coupon_total_count: Long,
    val item_description: String,
    val item_id: Long,
    val level_one_category_id: Int,
    val level_one_category_name: String,
    val nick: String,
    val pict_url: String,
    val seller_id: Long,
    val shop_title: Any,
    val small_images: SmallImages,
    val title: String,
    val user_type: Long,
    val volume: Long,
    val zk_final_price: String
)

data class SmallImages(
    val string: List<String>
)