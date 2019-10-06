package com.padcmyanmar.padc9.myplantkotlinapplication.mvp.presenters

import com.padcmyanmar.padc9.myplantkotlinapplication.data.models.PlantModelImpl
import com.padcmyanmar.padc9.myplantkotlinapplication.mvp.views.FavPlantListView

class FavPlantListPresenter : BasePresenter<FavPlantListView>() {

    override fun onCreate() {
        super.onCreate()
        PlantModelImpl.getPlants({
            mView.showFavPlantList(it)
        },{
            mView.showErrorMessage(it)
        })
    }
}