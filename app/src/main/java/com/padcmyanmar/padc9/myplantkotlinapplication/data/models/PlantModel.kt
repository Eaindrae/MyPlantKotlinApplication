package com.padcmyanmar.padc9.myplantkotlinapplication.data.models

import com.padcmyanmar.padc9.myplantkotlinapplication.data.vos.FavPlantsVo
import com.padcmyanmar.padc9.myplantkotlinapplication.data.vos.PlantVO

interface PlantModel {


    fun getPlants(

        onSuccess:(List<PlantVO>)->Unit,
        onFailure:(String)->Unit
    )
    fun getPlantsById(plantId:String):PlantVO



    fun getFavPlants(
        onSuccess: (List<PlantVO>) -> Unit, onFailure: (String) -> Unit
    )

    fun getFavPlantByPlantId(plantId: String): FavPlantsVo

    fun addFavPlant(favPlantsVo: FavPlantsVo)

    fun removeFavPlant(favPlantsVo: FavPlantsVo)
}