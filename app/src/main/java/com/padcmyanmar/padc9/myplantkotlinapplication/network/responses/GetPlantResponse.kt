package com.padcmyanmar.padc9.myplantkotlinapplication.network.responses

import com.google.gson.annotations.SerializedName
import com.padcmyanmar.padc9.myplantkotlinapplication.Utils.CODE_RESPONSE_OK
import com.padcmyanmar.padc9.myplantkotlinapplication.data.vos.PlantVO

data class GetPlantResponse (

    @SerializedName("code")
    val code: Int,

    @SerializedName("message")
    val message: String,

    @SerializedName("data")
    val data: List<PlantVO>?
){
    fun isResponseOk(): Boolean {
        return code == CODE_RESPONSE_OK && data != null
    }
}


