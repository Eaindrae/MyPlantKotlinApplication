package com.padcmyanmar.padc9.myplantkotlinapplication.network.dataAgents

import com.padcmyanmar.padc9.myplantkotlinapplication.data.vos.UserVO
import com.padcmyanmar.padc9.myplantkotlinapplication.data.vos.PlantVO

interface PlantDataAgents {

    fun getPlants(

        onSuccess: (List<PlantVO>) -> Unit,
        onFailure: (String) -> Unit
    )
    fun login(
        email: String,
        password: String,
        onSuccess: (UserVO) -> Unit,
        onFailure: (String) -> Unit
    )
}