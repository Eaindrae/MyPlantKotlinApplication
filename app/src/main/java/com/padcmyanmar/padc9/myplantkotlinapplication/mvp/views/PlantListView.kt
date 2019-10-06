package com.padcmyanmar.padc9.myplantkotlinapplication.mvp.views

import com.padcmyanmar.padc9.myplantkotlinapplication.data.vos.PlantVO
import com.padcmyanmar.padc9.myplantkotlinapplication.data.vos.UserVO

interface PlantListView:BaseView{
    fun displayPlanttList(plantList:List<PlantVO>)
    fun displayError(errorMessage:String)
    fun navigateToDetail(plantId:String)

    fun bindUserDataToNav(userVo: UserVO)
    fun navigateToFavList()

    fun logout()
}