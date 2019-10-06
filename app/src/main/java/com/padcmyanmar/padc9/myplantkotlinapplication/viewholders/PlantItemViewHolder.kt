package com.padcmyanmar.padc9.myplantkotlinapplication.viewholders

import android.view.View
import coil.api.load
import com.padcmyanmar.padc9.myplantkotlinapplication.data.vos.PlantVO
import com.padcmyanmar.padc9.myplantkotlinapplication.delegates.PlantItemDelegate
import kotlinx.android.synthetic.main.plant_view_item.view.*

class PlantItemViewHolder(itemView: View,private val delegate:PlantItemDelegate)
    :BaseViewHolder<PlantVO>(itemView) {

    init{
        itemView.setOnClickListener {
            data?.plantid?.let {
                delegate.onTapPlantItem(it)
            }
        }
    }

    override fun bindData(data: PlantVO) {


        with(itemView) {
            fav_toggle.setOnClickListener {

                delegate.favButtonClicked(data.plantid, fav_toggle.isChecked)
            }
            tv_plant_title.text = data.plant_name
            iv_profile.load(data.uploadedUserVo.user_photo)
            tv__name.text = "by ${data.uploadedUserVo.name}"
            itemView.iv_plant1.load(data.plantPhoto){
                crossfade(true)
                crossfade(2000)
            }
        }
    }

}