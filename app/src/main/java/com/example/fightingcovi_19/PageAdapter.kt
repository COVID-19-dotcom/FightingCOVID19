package com.example.fightingcovi_19

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter

class PageAdapter(var layouts: IntArray,var con: Context) : PagerAdapter() {

    var inflater : LayoutInflater = con.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater


    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return layouts.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view : View = inflater.inflate(layouts[position],container,false)
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val view : View = `object` as View
        container.removeView(view)
    }
}