package com.masai.taskmanagerapp.models.remote.requests

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LoginRequestModel(@SerializedName("email")
                             val userName: String, @SerializedName("password")val password: String) {
}