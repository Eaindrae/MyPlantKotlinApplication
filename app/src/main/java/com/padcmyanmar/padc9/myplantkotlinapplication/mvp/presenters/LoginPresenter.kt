package com.padcmyanmar.padc9.myplantkotlinapplication.mvp.presenters

import com.padcmyanmar.padc9.myplantkotlinapplication.data.models.LoginModelImpl
import com.padcmyanmar.padc9.myplantkotlinapplication.mvp.views.LoginView

class LoginPresenter :BasePresenter<LoginView>(){

    override fun onStart() {
        super.onStart()
        val loggedInUser = LoginModelImpl.checkLoggedIn()
        if(loggedInUser != null)
        {
            mView.navigateToPlantList(loggedInUser.user_id)
        }
    }

    fun login(email:String,password:String){
        LoginModelImpl.login(email,password,{
            mView.navigateToPlantList(it.user_id)
        },{
            mView.showErrorMessage(it)
        })
    }

}