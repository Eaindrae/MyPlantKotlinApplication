package com.padcmyanmar.padc9.myplantkotlinapplication.mvp.presenters

import com.padcmyanmar.padc9.myplantkotlinapplication.data.models.PlantModelImpl
import com.padcmyanmar.padc9.myplantkotlinapplication.mvp.views.PlantDetailView

class PlantDetailPresenter:BasePresenter<PlantDetailView>(){

    fun favButtonClicked(plantId : String){
        mView.favButtonClicked(plantId)
    }
    fun onUIReady(plantId:String){
//        if (plantId != 0) {
            val model =PlantModelImpl
            val plantVO = model.getPlantsById(plantId)
            mView.displayPlantData(plantVO)
//        }
    }

    override fun onCreate(){}
    override fun onStart(){}
    override fun onResume(){}
    override  fun onPause(){}
    override fun onStop(){}
    //override fun onDestory(){}
}