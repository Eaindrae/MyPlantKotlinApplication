package com.padcmyanmar.padc9.myplantkotlinapplication.viewholders

import android.view.View
import coil.api.load
import com.padcmyanmar.padc9.myplantkotlinapplication.R

import com.padcmyanmar.padc9.myplantkotlinapplication.data.vos.TipsVO
import kotlinx.android.synthetic.main.tips_view_item.view.*

class TipsItemViewHolder(itemView: View) : BaseViewHolder<TipsVO>(itemView) {
    override fun bindData(data: TipsVO) {

      //  itemView.tv_temp_num.text = data.temperature

        if(data.light.isNotEmpty()){

            itemView.card.setBackgroundColor(itemView.resources.getColor(R.color.colorAccent))
            itemView.ibtn_temp.load(R.drawable.light)
            itemView.tipsTitle.text = "Light"
            itemView.tipsDesc.text = data.light
        } else if(data.temperature.isNotEmpty()){
            itemView.card.setBackgroundColor(itemView.resources.getColor(R.color.colorPrimary))

            itemView.ibtn_temp.load(R.drawable.temperature)
            itemView.tipsTitle.text = "Temperature"
            itemView.tipsDesc.text = data.temperature
        }else if(data.placement.isNotEmpty()){
            itemView.card.setBackgroundColor(itemView.resources.getColor(R.color.colorAccent))

            itemView.ibtn_temp.load(R.drawable.light)
            itemView.tipsTitle.text = "Placement"
            itemView.tipsDesc.text = data.placement
        }
    }
}