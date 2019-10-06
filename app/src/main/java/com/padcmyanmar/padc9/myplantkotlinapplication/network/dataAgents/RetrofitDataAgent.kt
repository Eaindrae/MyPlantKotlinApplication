package com.padcmyanmar.padc9.myplantkotlinapplication.network.dataAgents

import com.padcmyanmar.padc9.myplantkotlinapplication.Utils.BASE_URL
import com.padcmyanmar.padc9.myplantkotlinapplication.Utils.EM_NULL_PlANT_RESPONESE
import com.padcmyanmar.padc9.myplantkotlinapplication.data.vos.UserVO
import com.padcmyanmar.padc9.myplantkotlinapplication.data.vos.PlantVO
import com.padcmyanmar.padc9.myplantkotlinapplication.network.PlantsApi
import com.padcmyanmar.padc9.myplantkotlinapplication.network.responses.GetPlantResponse
import com.padcmyanmar.padc9.myplantkotlinapplication.network.responses.LoginResponse
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitDataAgent : PlantDataAgents {


    private val PLANT_API: PlantsApi

    init {

        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        PLANT_API = retrofit.create(PlantsApi::class.java)
    }
    override fun login(
        email: String,
        password: String,
        onSuccess: (UserVO) -> Unit,
        onFailure: (String) -> Unit
    ) {
        val call = PLANT_API.login(email = email,password = password)
        call.enqueue(object : Callback<LoginResponse> {
            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                onFailure(t.localizedMessage)
            }

            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                val loginResponse = response.body()
                if (loginResponse != null) {
                    if (loginResponse.isResponseOk())
                        onSuccess(loginResponse.data!!)
                    else
                        onFailure(response.message())
                } else {
                    onFailure(EM_NULL_PlANT_RESPONESE)
                }
            }
        })
    }
    override fun getPlants(onSuccess: (List<PlantVO>) -> Unit, onFailure: (String) -> Unit) {
        PLANT_API.getAllPlants().enqueue(object : Callback<GetPlantResponse> {
            override fun onFailure(call: Call<GetPlantResponse>, t: Throwable) {
                onFailure(t.localizedMessage)
            }

            override fun onResponse(call: Call<GetPlantResponse>, response: Response<GetPlantResponse>) {
                val response = response.body()
                if (response != null) {
                    if (response.isResponseOk()) {
                        onSuccess(response.data!!)
                    } else {
                        onFailure(response.message)
                    }
                } else {
                    onFailure(EM_NULL_PlANT_RESPONESE)
                }
            }

        })
    }
}