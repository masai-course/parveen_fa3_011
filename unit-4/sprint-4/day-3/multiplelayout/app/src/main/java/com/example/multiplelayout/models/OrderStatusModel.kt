package com.example.multiplelayout.models

data class OrderStatusModel(
    val accessToken: String,
    val accountId: String,
    val error: Boolean,
    val error_code: Int,
    val msg1: String,
    val msg2: String,
    val orderId: String,
    val order_status: String
)