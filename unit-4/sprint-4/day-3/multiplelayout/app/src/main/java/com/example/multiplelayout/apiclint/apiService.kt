package com.example.multiplelayout.apiclint

import com.example.multiplelayout.models.CancelModel
import com.example.multiplelayout.models.OrderStatusModel
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface apiService {

    @FormUrlEncoded
    @POST("api/method/chatbotGetOrderStatus.inc.php")
    suspend fun getstatus(
        @Field("accountId") accountId: String?,
        @Field("accessToken") accessToken: String?,
        @Field("orderId") orderId: String?
    ): Call<OrderStatusModel>

    @FormUrlEncoded
    @POST("api/method/chatbotCancelOrder.inc.php")
    suspend fun getcancel(
        @Field("accountId") accountId: String?,
        @Field("accessToken") accessToken: String?,
        @Field("orderId") orderId: String?
    ): Call<CancelModel>

}