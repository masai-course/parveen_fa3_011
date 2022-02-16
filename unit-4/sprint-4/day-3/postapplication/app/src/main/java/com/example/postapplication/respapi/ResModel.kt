package com.example.postapplication.respapi

data class ResModel(
    val error: Boolean,
    val error_code: Int,
    val message: String,
    val order_status: List<OrderStatu>
)