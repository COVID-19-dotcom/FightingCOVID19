package com.example.fightingcovi_19

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager

class AppIntro : AppCompatActivity(),View.OnClickListener {

    override fun onClick(p0: View?) {
        when(p0!!.id)
        {
            R.id.btnSkip->
            {
                loadHome()
                PrefManager(this).writeSP()
            }
            R.id.btnNext->
            {
                loadNextSlide()
            }
        }
    }

    private fun loadNextSlide() {
        val nextSlide : Int = mPager.currentItem + 1

        if(nextSlide<layouts.size)
        {
            mPager.setCurrentItem(nextSlide)
        }
        else
        {
            loadHome()
            PrefManager(this).writeSP()
        }
    }

    private fun loadHome() {
        startActivity(Intent(applicationContext,GuestTesting::class.java))
        finish()
    }

    lateinit var mPager : ViewPager
    var layouts : IntArray = intArrayOf(R.layout.intro_slide1,R.layout.intro_slide2,R.layout.intro_slide3,R.layout.intro_slide4,R.layout.intro_slide5)

    lateinit var dotsLayout: LinearLayout
    lateinit var dots:Array<ImageView>

    lateinit var btnNext : Button
    lateinit var btnSkip : Button

    lateinit var mAdapter : PageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_intro)

        if(PrefManager(this).checkPreference()) {
            loadHome()
        }

        if(Build.VERSION.SDK_INT>=19)
        {
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        }
        else
        {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        }

        mPager = findViewById(R.id.pager)

        mAdapter = PageAdapter(layouts,this)
        mPager.adapter = mAdapter

        dotsLayout = findViewById<LinearLayout>(R.id.dots)
        btnNext = findViewById(R.id.btnNext)
        btnSkip = findViewById(R.id.btnSkip)
        btnSkip.setOnClickListener(this)
        btnNext.setOnClickListener(this)


        createDots(0)

        mPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                createDots(position)

                if(position == layouts.size-1)
                {
                    btnNext.setText("Start")
                    btnSkip.visibility = View.VISIBLE
                }
                else
                {
                    btnNext.setText("Next")
                    btnSkip.visibility = View.VISIBLE
                }
            }

        })
    }

    fun createDots(position:Int)
    {
        dotsLayout.removeAllViews()
        dots = Array(layouts.size) { ImageView(this) }

        for(i in layouts.indices)
        {
            dots[i] = ImageView(this)
            if( i == position)
            {
                dots[i].setImageDrawable(ContextCompat.getDrawable(this,R.drawable.active_intro))
            }
            else
            {
                dots[i].setImageDrawable(ContextCompat.getDrawable(this,R.drawable.inactive_intro))
            }
            val params : LinearLayout.LayoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT)
            params.setMargins(4,0,4,0)
            dotsLayout.addView(dots[i],params)
        }
    }

}
