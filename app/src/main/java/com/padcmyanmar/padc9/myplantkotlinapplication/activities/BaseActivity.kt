package com.padcmyanmar.padc9.myplantkotlinapplication.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.padcmyanmar.padc9.myplantkotlinapplication.data.models.LoginModelImpl
import com.padcmyanmar.padc9.myplantkotlinapplication.data.models.PlantModel
import com.padcmyanmar.padc9.myplantkotlinapplication.data.models.PlantModelImpl

abstract class BaseActivity: AppCompatActivity(){
    //constr htae mar initialize ma lote bae, ta chain chain mar lote mae
    //onCreate mar ma initialize lote mae
    protected  lateinit var model:PlantModelImpl
    protected lateinit var userDataAgent: LoginModelImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        model =PlantModelImpl
        userDataAgent = LoginModelImpl
    }

    fun showSnackBar(message: String) {
        val snackBar = Snackbar.make(window.decorView, message, Snackbar.LENGTH_INDEFINITE)
        snackBar.setAction("OK") { snackBar.dismiss() }
        snackBar.show()
    }
}