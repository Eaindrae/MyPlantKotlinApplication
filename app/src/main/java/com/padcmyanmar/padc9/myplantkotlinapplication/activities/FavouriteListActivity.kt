package com.padcmyanmar.padc9.myplantkotlinapplication.activities

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.padcmyanmar.padc9.myplantkotlinapplication.Adapters.FavPlantListRecyclerAdapter
import com.padcmyanmar.padc9.myplantkotlinapplication.R
import com.padcmyanmar.padc9.myplantkotlinapplication.data.vos.PlantVO
import com.padcmyanmar.padc9.myplantkotlinapplication.mvp.presenters.FavPlantListPresenter
import com.padcmyanmar.padc9.myplantkotlinapplication.mvp.views.FavPlantListView
import kotlinx.android.synthetic.main.activity_favourite_list.*

class FavouriteListActivity : BaseActivity(), FavPlantListView {
    override fun showFavPlantList(plantList: List<PlantVO>) {
        favPlantListRecyclerAdapter.setNewData(plantList.toMutableList())
    }

    override fun showErrorMessage(message: String) {
        showSnackBar(message)
    }

    private lateinit var favPlantListRecyclerAdapter: FavPlantListRecyclerAdapter
    private lateinit var mPresenter: FavPlantListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favourite_list)
        mPresenter = FavPlantListPresenter()
        mPresenter.initPresenter(this)
        favPlantListRecyclerAdapter = FavPlantListRecyclerAdapter()
        with(favPlantRecyclerList) {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(context, 2)
            adapter = favPlantListRecyclerAdapter
        }
        mPresenter.onCreate()

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
