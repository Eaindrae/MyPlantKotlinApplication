package com.padcmyanmar.padc9.myplantkotlinapplication.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcmyanmar.padc9.myplantkotlinapplication.R
import com.padcmyanmar.padc9.myplantkotlinapplication.data.vos.PlantVO
import com.padcmyanmar.padc9.myplantkotlinapplication.delegates.PlantItemDelegate
import com.padcmyanmar.padc9.myplantkotlinapplication.viewholders.PlantItemViewHolder

class PlantItemAdapter(private val delegates: PlantItemDelegate)
    :BaseAdapter<PlantItemViewHolder,PlantVO >() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.plant_view_item,parent,false)
        return PlantItemViewHolder(view,delegates)
    }
//    override fun getItemCount(): Int {
//        return 5
//    }
//
//    override fun onBindViewHolder(holder: PlantItemViewHolder, position: Int) {
//
//    }
}