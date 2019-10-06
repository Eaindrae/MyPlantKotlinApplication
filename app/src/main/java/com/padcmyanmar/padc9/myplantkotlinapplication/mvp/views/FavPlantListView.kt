package com.padcmyanmar.padc9.myplantkotlinapplication.mvp.views

import com.padcmyanmar.padc9.myplantkotlinapplication.data.vos.PlantVO

interface FavPlantListView  : BaseView {

    fun showFavPlantList(plantList: List<PlantVO>)
    fun showErrorMessage(message:String)
}