package com.padcmyanmar.padc9.myplantkotlinapplication.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import coil.api.load
import com.padcmyanmar.padc9.myplantkotlinapplication.Adapters.TipsItemAdapter
import com.padcmyanmar.padc9.myplantkotlinapplication.R
import com.padcmyanmar.padc9.myplantkotlinapplication.data.vos.PlantVO
import com.padcmyanmar.padc9.myplantkotlinapplication.data.vos.TipsVO
import com.padcmyanmar.padc9.myplantkotlinapplication.mvp.presenters.PlantDetailPresenter
import com.padcmyanmar.padc9.myplantkotlinapplication.mvp.views.PlantDetailView
import kotlinx.android.synthetic.main.acitvity_login.*
import kotlinx.android.synthetic.main.activity_detail.*

class PlantDetailActivity : BaseActivity(), PlantDetailView {
    override fun displayPlantData(plantData: PlantVO) {
        tv_plant_detail_title.text = plantData.plant_name
        iv_detail_profile.load(plantData.uploadedUserVo.user_photo)
        tv__uploader_name.text = plantData.uploadedUserVo.name
        tv_description.text = plantData.description
        //   val plantImagePagerAdapter = PlantImagePagerAdapter(plantVo.plantPhoto)
        // vpPlantImages.adapter = plantImagePagerAdapter
        val tips = arrayListOf(
            TipsVO("", plantData.tips.light, ""),
            TipsVO(plantData.tips.temperature, "", ""),
            TipsVO("", "", plantData.tips.placement)
        )
        tipsRecyclerAdapter.appendNewData(tips)
        btn_fav.setOnClickListener {
            mPresenter.favButtonClicked(plantData.plantid)
        }    }


    companion object {
        private const val IE_PLANT_ID = "intentPlant"
        fun newIntent(context: Context, id: String): Intent {
            val intent = Intent(context, PlantDetailActivity::class.java)
            intent.putExtra(IE_PLANT_ID, id)
            return intent
        }
    }

    private lateinit var tipsRecyclerAdapter: TipsItemAdapter
    private lateinit var mPresenter: PlantDetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setSupportActionBar(toolbar)
        mPresenter = PlantDetailPresenter()
        mPresenter.initPresenter(this)
        tipsRecyclerAdapter = TipsItemAdapter()
        mPresenter.onUIReady(intent.getStringExtra(IE_PLANT_ID)!!)
        with(tipsRecyclerView) {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = tipsRecyclerAdapter
        }
    }


    override fun favButtonClicked(plantId: String) {
        Toast.makeText(this, "favButtonClicked clicked", Toast.LENGTH_SHORT).show()

    }

    override fun onStart() {
        super.onStart()
        mPresenter.onStart()
    }

    override fun onStop() {
        super.onStop()
        mPresenter.onStop()
    }

    override fun onResume() {
        super.onResume()
        mPresenter.onResume()
    }

    override fun onPause() {
        super.onPause()
        mPresenter.onPause()
    }

//    override fun onDestroy() {
//        super.onDestroy()
//        mPresenter.onDestroy()
//    }
}
