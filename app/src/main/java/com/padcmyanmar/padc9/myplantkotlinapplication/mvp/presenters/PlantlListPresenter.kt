package com.padcmyanmar.padc9.myplantkotlinapplication.mvp.presenters

import android.util.Log
import com.padcmyanmar.padc9.myplantkotlinapplication.data.models.LoginModelImpl
import com.padcmyanmar.padc9.myplantkotlinapplication.data.models.PlantModelImpl
import com.padcmyanmar.padc9.myplantkotlinapplication.data.vos.FavPlantsVo
import com.padcmyanmar.padc9.myplantkotlinapplication.data.vos.UserVO
import com.padcmyanmar.padc9.myplantkotlinapplication.delegates.PlantItemDelegate
import com.padcmyanmar.padc9.myplantkotlinapplication.mvp.views.PlantListView

class PlantlListPresenter :BasePresenter<PlantListView>(),PlantItemDelegate {
    override fun onTapPlantItem(plantId: String) {
        mView.navigateToDetail(plantId)
    }

    override fun favButtonClicked(plantId: String,toggleStatus:Boolean) {
        var favPlantsVo = FavPlantsVo(plantId = plantId,id = 0)
        if(toggleStatus)
            PlantModelImpl.addFavPlant(favPlantsVo)
        else
        {
            favPlantsVo =  PlantModelImpl.getFavPlantByPlantId(plantId)
            PlantModelImpl.removeFavPlant(favPlantsVo)
        }
    }
    override fun onCreate(){
        val model:PlantModelImpl = PlantModelImpl
        model.getPlants(
            {
                mView.displayPlanttList(it)
                Log.d("PlantModel",it.toString())
            },{
                mView.displayError(it)
            }

        )

    }

    fun navFavClicked(){
        mView.navigateToFavList()
    }

    fun onUiReady()
    {
        mView.bindUserDataToNav(LoginModelImpl.checkLoggedIn()!!)
    }

    fun navLogoutClicked(userVo: UserVO)
    {
        LoginModelImpl.logout(userVo)
        mView.logout()
    }

    override fun onStart(){}
    override fun onResume(){}
    override fun onPause(){}
    override fun onStop(){}
    override fun onDestory(){}

}