package com.padcmyanmar.padc9.myplantkotlinapplication.network


import com.padcmyanmar.padc9.myplantkotlinapplication.Utils.GET_LOGIN
import com.padcmyanmar.padc9.myplantkotlinapplication.Utils.GET_PLANTS
import com.padcmyanmar.padc9.myplantkotlinapplication.Utils.PARAM_EMAIL
import com.padcmyanmar.padc9.myplantkotlinapplication.Utils.PARAM_PASSWORD
import com.padcmyanmar.padc9.myplantkotlinapplication.network.responses.GetPlantResponse
import com.padcmyanmar.padc9.myplantkotlinapplication.network.responses.LoginResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface PlantsApi {

    @POST(GET_PLANTS)
    fun getAllPlants(): Call<GetPlantResponse>

    @POST(GET_LOGIN)
    @FormUrlEncoded
    fun login(@Field(PARAM_EMAIL) email: String, @Field(PARAM_PASSWORD) password: String): Call<LoginResponse>

}