package com.padcmyanmar.padc9.myplantkotlinapplication

import android.app.Application
import com.padcmyanmar.padc9.myplantkotlinapplication.data.models.LoginModelImpl
import com.padcmyanmar.padc9.myplantkotlinapplication.data.models.PlantModelImpl

class PlantsApp: Application() {

    override fun onCreate() {
        super.onCreate()
        PlantModelImpl.initDatabase(applicationContext)
        LoginModelImpl.initDatabase(applicationContext)
    }
}