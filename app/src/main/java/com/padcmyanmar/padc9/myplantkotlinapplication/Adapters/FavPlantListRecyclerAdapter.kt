package com.padcmyanmar.padc9.myplantkotlinapplication.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcmyanmar.padc9.myplantkotlinapplication.R
import com.padcmyanmar.padc9.myplantkotlinapplication.data.vos.PlantVO
import com.padcmyanmar.padc9.myplantkotlinapplication.viewholders.FavPlantImageViewHolder

class FavPlantListRecyclerAdapter :
    BaseAdapter<FavPlantImageViewHolder, PlantVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavPlantImageViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_fav_image_card, parent, false)
        return FavPlantImageViewHolder(view)
    }
}