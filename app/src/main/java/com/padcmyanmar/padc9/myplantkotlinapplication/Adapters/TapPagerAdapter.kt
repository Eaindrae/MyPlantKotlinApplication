package com.padcmyanmar.padc9.myplantkotlinapplication.Adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.padcmyanmar.padc9.myplantkotlinapplication.fragments.AlbumFragment
import com.padcmyanmar.padc9.myplantkotlinapplication.fragments.ColorFragment
import com.padcmyanmar.padc9.myplantkotlinapplication.fragments.OldFragment
import com.padcmyanmar.padc9.myplantkotlinapplication.fragments.RecentFragment

class TapPagerAdapter(fm: FragmentManager): FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> RecentFragment()
            1 -> OldFragment()
            2 -> ColorFragment()
            else -> AlbumFragment()
        }
    }

    override fun getCount(): Int {
        return 4
    }


    override fun getPageTitle(position: Int): CharSequence {
        return when (position){
            0 -> "Recent"
            1 -> "Old"
            2-> "Color"
            else -> "Album"
        }
    }



}