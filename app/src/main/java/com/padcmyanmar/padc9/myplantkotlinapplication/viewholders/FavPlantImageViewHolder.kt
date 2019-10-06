package com.padcmyanmar.padc9.myplantkotlinapplication.viewholders

import android.view.View
import coil.api.load
import com.padcmyanmar.padc9.myplantkotlinapplication.data.vos.PlantVO
import kotlinx.android.synthetic.main.item_fav_image_card.view.*

class FavPlantImageViewHolder(itemView: View) :
    BaseViewHolder<PlantVO>(itemView) {

    override fun bindData(data: PlantVO) {
        itemView.fav_image.load(data.plantPhoto)
    }
}