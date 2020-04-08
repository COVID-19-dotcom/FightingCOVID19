package com.example.fightingcovi_19

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler().postDelayed({
            val pref = getSharedPreferences("Login",Context.MODE_PRIVATE)
            if(pref.getString("type",null) == null) {
                startActivity(Intent(this, AppIntro::class.java))
                finish()
            }else if(pref.getString("type",null) == "user"){
                startActivity(Intent(this, UserDashboard::class.java))
                finish()
            }

        },2000)
    }
}
