package com.padcmyanmar.padc9.myplantkotlinapplication.activities

import android.os.Bundle

import android.content.Intent
import android.view.View
import com.padcmyanmar.padc9.myplantkotlinapplication.R
import com.padcmyanmar.padc9.myplantkotlinapplication.mvp.presenters.LoginPresenter
import com.padcmyanmar.padc9.myplantkotlinapplication.mvp.views.LoginView
import kotlinx.android.synthetic.main.acitvity_login.*


class LoginActivity:BaseActivity(),LoginView {

    override fun showErrorMessage(message: String) {
        showSnackBar(message)
    }

    private lateinit var mPresenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acitvity_login)
        mPresenter = LoginPresenter()
        mPresenter.initPresenter(this)


        btn_login.setOnClickListener {
         val email = et_email.text.toString()
        val password = et_password.text.toString()
        mPresenter.login(email,password)

        }
        mPresenter.onCreate()

    }
    fun login(view: View){
        val email = et_email.text.toString()
        val password = et_password.text.toString()
        mPresenter.login(email,password)

    }
    override fun navigateToPlantList(userId:String) {
        startActivity(MainActivity.newIntent(this,userId))
        finish()
    }

    override fun onStart() {
        super.onStart()
        mPresenter.onStart()
    }

    override fun onStop() {
        super.onStop()
        mPresenter.onStop()
    }

    override fun onResume() {
        super.onResume()
        mPresenter.onResume()
    }

    override fun onPause() {
        super.onPause()
        mPresenter.onPause()
    }

//    override fun onDestroy() {
//        super.onDestroy()
//        mPresenter.onDestroy()
//    }
}