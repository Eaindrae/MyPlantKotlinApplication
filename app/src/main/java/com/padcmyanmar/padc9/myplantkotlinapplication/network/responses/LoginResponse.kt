package com.padcmyanmar.padc9.myplantkotlinapplication.network.responses

import com.google.gson.annotations.SerializedName
import com.padcmyanmar.padc9.myplantkotlinapplication.Utils.CODE_RESPONSE_OK
import com.padcmyanmar.padc9.myplantkotlinapplication.data.vos.UserVO

data class LoginResponse(
    @SerializedName("code")
    val code:Int,
    @SerializedName("message")
    val message:String,
    @SerializedName("data")
    val data:UserVO?) {
    fun isResponseOk(): Boolean {
        return code == CODE_RESPONSE_OK && data != null
    }
}