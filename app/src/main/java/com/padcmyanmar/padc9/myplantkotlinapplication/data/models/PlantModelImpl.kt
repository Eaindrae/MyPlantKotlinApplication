package com.padcmyanmar.padc9.myplantkotlinapplication.data.models

import android.util.Log
import com.padcmyanmar.padc9.myplantkotlinapplication.data.vos.FavPlantsVo
import com.padcmyanmar.padc9.myplantkotlinapplication.data.vos.PlantVO

object PlantModelImpl:PlantModel,BaseModel() {



    override fun removeFavPlant(favPlantsVo: FavPlantsVo) {
        dataBase.favPlantDao().removeFavPlant(favPlantsVo)
    }

    override fun getFavPlantByPlantId(plantId: String): FavPlantsVo {
        return dataBase.favPlantDao().getFavPlantByPlantId(plantId)
    }

    override fun addFavPlant(favPlantsVo: FavPlantsVo) {
        dataBase.favPlantDao().insetFavPlant(favPlantsVo)
    }

    override fun getFavPlants(onSuccess: (List<PlantVO>) -> Unit, onFailure: (String) -> Unit) {
        val plantsFromDB = dataBase.favPlantDao().getFavPlantList()
        if (plantsFromDB.isNotEmpty()) {
            onSuccess(plantsFromDB)
        } else {
            onFailure("No Favourite Plant Added!!")
        }
    }
    override fun getPlants(onSuccess: (List<PlantVO>) -> Unit, onFailure: (String) -> Unit) {
        val plantDataFromDB = dataBase.plantDao().getPlants()
        if (plantDataFromDB.isNotEmpty()) {
            onSuccess(plantDataFromDB)
        } else {
            dataAgent.getPlants(

                onSuccess = {
                    dataBase.plantDao().insertPlants(it)
                    onSuccess(it)
                    Log.d("Model", it.toString())
                },
                onFailure = {

                }
            )
        }
    }
    override fun getPlantsById(plantId: String): PlantVO {
        return dataBase.plantDao().getPlantsById(plantId)
    }


}