package com.padcmyanmar.padc9.myplantkotlinapplication.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcmyanmar.padc9.myplantkotlinapplication.R
import com.padcmyanmar.padc9.myplantkotlinapplication.data.vos.PlantVO
import com.padcmyanmar.padc9.myplantkotlinapplication.data.vos.TipsVO
import com.padcmyanmar.padc9.myplantkotlinapplication.delegates.PlantItemDelegate
import com.padcmyanmar.padc9.myplantkotlinapplication.viewholders.PlantItemViewHolder
import com.padcmyanmar.padc9.myplantkotlinapplication.viewholders.TipsItemViewHolder

class TipsItemAdapter :BaseAdapter<TipsItemViewHolder, TipsVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TipsItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.tips_view_item,parent,false)
        return TipsItemViewHolder(view)
    }
//    override fun getItemCount(): Int {
//        return 5
//    }
//
//    override fun onBindViewHolder(holder: TipsItemViewHolder, position: Int) {
//
//    }
}