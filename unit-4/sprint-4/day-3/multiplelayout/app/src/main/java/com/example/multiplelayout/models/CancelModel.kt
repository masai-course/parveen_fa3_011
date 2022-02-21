package com.example.multiplelayout.models

data class CancelModel(
    val accessToken: String,
    val accountId: String,
    val error: Boolean,
    val error_code: Int,
    val orderId: String,
    val order_status: String
)