package com.padcmyanmar.padc9.myplantkotlinapplication.mvp.views

interface LoginView: BaseView {

    fun navigateToPlantList(userId:String)
    fun showErrorMessage(message:String)
}