package com.example.fightingcovi_19

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AccelerateInterpolator
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.daasuu.cat.CountAnimationTextView
import kotlinx.android.synthetic.main.activity_corona_info.*
import org.json.JSONException
import org.json.JSONObject

class CoronaInfo : AppCompatActivity() {


    private var mQueue: RequestQueue? = null
    private  var counttotal: CountAnimationTextView? = null
    private  var countconfirm: CountAnimationTextView? = null
    private var countrecovery: CountAnimationTextView? = null
    private  var countdeath: CountAnimationTextView? = null
    var confrim:Int = 0
    var death:Int =0
    var recovered:Int =0
    var total:Int=0
    var date=String()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_corona_info)

        nearby_navigator.setItemSelected(R.id.nearby,true)

        counttotal = findViewById(R.id.count_total)
        countconfirm = findViewById(R.id.count_confirm)
        countrecovery = findViewById(R.id.count_recovery)
        countdeath = findViewById(R.id.count_death)
        //count_recovery
        mQueue = Volley.newRequestQueue(this)

        refresh()

        nearby_navigator.setOnItemSelectedListener {
            if(it==R.id.home)
            {
                var intent= Intent(this,UserDashboard::class.java)
                startActivity(intent)
                finish()
            }
            if (it==R.id.profile)
            {
                var intent= Intent(this,UserProfile::class.java)
                startActivity(intent)
                finish()
            }
        }

    }

    fun refresh(){
        Handler().postDelayed(object : Runnable {
            override fun run() {
                // this method will contain your almost-finished HTTP calls
                jsonParse()
                counttotal?.setInterpolator(AccelerateInterpolator())?.countAnimation(0, total)
                countconfirm?.setInterpolator(AccelerateInterpolator())?.countAnimation(0, confrim)
                countrecovery?.setInterpolator(AccelerateInterpolator())?.countAnimation(0, recovered)
                countdeath?.setInterpolator(AccelerateInterpolator())?.countAnimation(0, death)
                Handler().postDelayed(this, 3500)
            }
        }, 2500)

    }


    private fun jsonParse() {
        val url = "https://pomber.github.io/covid19/timeseries.json"
        val request = JsonObjectRequest(
            Request.Method.GET, url, null,
            object : Response.Listener<JSONObject?> {
                @SuppressLint("SetTextI18n")
                override fun onResponse(response: JSONObject?) {
                    try {
                        val jsonArray = response?.getJSONArray("India")
                        for (i in 0 until jsonArray!!.length()) {
                            val employee = jsonArray.getJSONObject(i)
                            date = employee.getString("date")
                            confrim = employee.getInt("confirmed")
                            death = employee.getInt("deaths")
                            recovered = employee.getInt("recovered")
                            //  mTextViewResult?.text = "Date:$firstName,\nConfirmed:$age,\nDeaths:$mail,\nRecovered:$recovered\n\n"
                            total=(confrim+death+recovered)
                            txtdate?.text="Last Update at 11:59 AM Date: $date. It Will Automatic Update within 24 hours...."

                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }

            }, object : Response.ErrorListener {
                override fun onErrorResponse(error: VolleyError) {
                    error.printStackTrace()
                }
            })
        mQueue?.add(request)
    }
}
