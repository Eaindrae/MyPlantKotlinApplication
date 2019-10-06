package com.padcmyanmar.padc9.myplantkotlinapplication.data.models

import android.content.Context
import com.padcmyanmar.padc9.myplantkotlinapplication.network.dataAgents.PlantDataAgents
import com.padcmyanmar.padc9.myplantkotlinapplication.network.dataAgents.RetrofitDataAgent
import com.padcmyanmar.padc9.myplantkotlinapplication.persistence.PlantDB

abstract class BaseModel {

    protected  val dataAgent:PlantDataAgents =RetrofitDataAgent

    protected  lateinit var dataBase: PlantDB

    fun initDatabase(context: Context){
        dataBase = PlantDB.getInstance(context)
    }
}