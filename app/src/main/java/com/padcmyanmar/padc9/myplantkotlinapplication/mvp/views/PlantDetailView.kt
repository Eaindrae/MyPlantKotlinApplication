package com.padcmyanmar.padc9.myplantkotlinapplication.mvp.views

import com.padcmyanmar.padc9.myplantkotlinapplication.data.vos.PlantVO

interface PlantDetailView:BaseView {

    fun favButtonClicked(plantId: String)
    fun displayPlantData(plantData:PlantVO) //bind
}