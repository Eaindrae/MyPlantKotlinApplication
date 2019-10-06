package com.padcmyanmar.padc9.myplantkotlinapplication.delegates

interface PlantItemDelegate {
    fun onTapPlantItem(plantId:String)

    fun favButtonClicked(plantId: String,toggleStatus: Boolean)
}