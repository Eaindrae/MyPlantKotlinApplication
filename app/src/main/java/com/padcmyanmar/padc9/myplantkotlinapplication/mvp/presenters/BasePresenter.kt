package com.padcmyanmar.padc9.myplantkotlinapplication.mvp.presenters

import com.padcmyanmar.padc9.myplantkotlinapplication.mvp.views.BaseView

abstract class BasePresenter<T: BaseView> {

    protected lateinit var mView:T

    open fun initPresenter(view:T){
        this.mView = view
    }

    open fun onCreate(){}
    open fun onStart(){}
    open fun onResume(){}
    open fun onPause(){}
    open fun onStop(){}
    open  fun onDestory(){}
}