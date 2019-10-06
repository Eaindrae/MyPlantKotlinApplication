package com.padcmyanmar.padc9.myplantkotlinapplication.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar

import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.google.android.material.navigation.NavigationView
import com.padcmyanmar.padc9.myplantkotlinapplication.Adapters.PlantItemAdapter
import com.padcmyanmar.padc9.myplantkotlinapplication.R
import com.padcmyanmar.padc9.myplantkotlinapplication.data.vos.PlantVO
import com.padcmyanmar.padc9.myplantkotlinapplication.data.vos.UserVO
import com.padcmyanmar.padc9.myplantkotlinapplication.mvp.presenters.PlantlListPresenter
import com.padcmyanmar.padc9.myplantkotlinapplication.mvp.views.PlantListView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.nav_header_main.*

class MainActivity : BaseActivity(),PlantListView, NavigationView.OnNavigationItemSelectedListener  {


    override fun logout() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    companion object {
        private const val IE_USER = "intentUser"
        fun newIntent(context: Context, id: String): Intent {
            val intent = Intent(context, MainActivity::class.java)
            intent.putExtra(IE_USER, id)
            return intent
        }
    }

    private lateinit var plantAdapter: PlantItemAdapter
    private lateinit var mPresenter: PlantlListPresenter

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.nav_favourite) {
            mPresenter.navFavClicked()
        } else if (item.itemId == R.id.nav_logout) {
            mPresenter.navLogoutClicked(this.userVo)
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    lateinit var userVo: UserVO
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_bar_main)
        mPresenter = PlantlListPresenter()
        mPresenter.initPresenter(this)
        plantAdapter = PlantItemAdapter(mPresenter)
        mPresenter.onCreate()
        mPresenter.onUiReady()

        setSupportActionBar(toolbar1)
        val toggle = ActionBarDrawerToggle(
            this,
            drawer_layout,
            toolbar1,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
        nav_view.setNavigationItemSelectedListener(this)
        toggle.isDrawerIndicatorEnabled = true


        with(rv_plant) {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            adapter = plantAdapter
        }

    }
    override fun displayPlanttList(plantList: List<PlantVO>) {
        plantAdapter.setNewData(plantList.toMutableList())
    }

    override fun displayError(errorMessage: String) {
        showSnackBar(errorMessage)
    }

    override fun navigateToDetail(plantId: String) {
        startActivity(PlantDetailActivity.newIntent(this, plantId))
    }


    override fun navigateToFavList() {
        startActivity(Intent(this, FavouriteListActivity::class.java))
    }

    override fun bindUserDataToNav(userVo: UserVO) {
        this.userVo = userVo
        val view = nav_view.getHeaderView(0)
//        view.profileImage.load(userVo.user_photo_url)
//        view.userName.text = userVo.user_name
//        view.memberRankTextView.text = userVo.member_rank
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
