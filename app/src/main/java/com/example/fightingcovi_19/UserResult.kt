package com.example.fightingcovi_19

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.telephony.SmsManager
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.mikhaellopez.circularprogressbar.CircularProgressBar
import kotlinx.android.synthetic.main.activity_user_result.*

class UserResult : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_result)

            check()
        SendSMS.setOnClickListener {
            sendSMS()
         }
        imgbutton.setOnClickListener {
            var intent=Intent(this,UserDashboard::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun sendSMS()
    {

        var intentkey1=intent
        var key2=intentkey1.getStringExtra("key2")
        var num=key2
        val messageToSend = "Your Patient get your Advise for His/Her Treatment.\nPlease Call them....."
        val number = num
        SmsManager.getDefault().sendTextMessage(number,null,messageToSend,null,null)
        val contextView = findViewById<View>(android.R.id.content)
        val snack=Snackbar.make(contextView,"Sms Will be Sended.",Snackbar.LENGTH_LONG)
        snack.show()
    }
    fun check()
    {

        var intentkey1=intent
        val key1=intentkey1.getStringExtra("key1")
        //var key2=intentkey1.getStringExtra("key2")
        //var num=key2
        if (key1.toString().toInt() ==75)
        {
            val circularProgressBar = findViewById<CircularProgressBar>(R.id.circularProgressBar)
            circularProgressBar.apply {
                // Set Progress
                progress = 100f
                // or with animation
                setProgressWithAnimation(83f, 3000) // =1s

                // Set Progress Max
                progressMax = 100f

                // Set ProgressBar Color
                progressBarColor = Color.BLUE
                // or with gradient
                progressBarColorStart = Color.parseColor("#13547a")
                progressBarColorEnd = Color.parseColor("#80d0c7")
                progressBarColorDirection = CircularProgressBar.GradientDirection.RIGHT_TO_LEFT

                // Set background ProgressBar Color
                backgroundProgressBarColor = Color.GRAY
                // or with gradient
                //   backgroundProgressBarColorStart = Color.WHITE
                //  backgroundProgressBarColorEnd = Color.RED
                backgroundProgressBarColorDirection = CircularProgressBar.GradientDirection.TOP_TO_BOTTOM

                // Set Width
                progressBarWidth = 29f // in DP
                backgroundProgressBarWidth = 20f // in DP

                // Other
                roundBorder = true
                startAngle = 180f
                progressDirection = CircularProgressBar.ProgressDirection.TO_RIGHT
            }
            txt_result.text ="Your result is upto 75%...\nYou need Doctor attention."
        }
        if (key1.toString().toInt() ==70)
        {
            val circularProgressBar = findViewById<CircularProgressBar>(R.id.circularProgressBar)
            circularProgressBar.apply {
                // Set Progress
                progress = 100f
                // or with animation
                setProgressWithAnimation(70f, 3000) // =1s

                // Set Progress Max
                progressMax = 100f

                // Set ProgressBar Color
                progressBarColor = Color.BLUE
                // or with gradient
                progressBarColorStart = Color.parseColor("#13547a")
                progressBarColorEnd = Color.parseColor("#80d0c7")
                progressBarColorDirection = CircularProgressBar.GradientDirection.RIGHT_TO_LEFT

                // Set background ProgressBar Color
                backgroundProgressBarColor = Color.GRAY
                // or with gradient
                //   backgroundProgressBarColorStart = Color.WHITE
                //  backgroundProgressBarColorEnd = Color.RED
                backgroundProgressBarColorDirection = CircularProgressBar.GradientDirection.TOP_TO_BOTTOM

                // Set Width
                progressBarWidth = 29f // in DP
                backgroundProgressBarWidth = 20f // in DP

                // Other
                roundBorder = true
                startAngle = 180f
                progressDirection = CircularProgressBar.ProgressDirection.TO_RIGHT
            }
            txt_result.text ="Your result is upto 70%...\nYou need Doctor attention."
        }
        if (key1.toString().toInt() ==80)
        {
            val circularProgressBar = findViewById<CircularProgressBar>(R.id.circularProgressBar)
            circularProgressBar.apply {
                // Set Progress
                progress = 100f
                // or with animation
                setProgressWithAnimation(80f, 3000) // =1s

                // Set Progress Max
                progressMax = 100f

                // Set ProgressBar Color
                progressBarColor = Color.BLUE
                // or with gradient
                progressBarColorStart = Color.parseColor("#13547a")
                progressBarColorEnd = Color.parseColor("#80d0c7")
                progressBarColorDirection = CircularProgressBar.GradientDirection.RIGHT_TO_LEFT

                // Set background ProgressBar Color
                backgroundProgressBarColor = Color.GRAY
                // or with gradient
                //   backgroundProgressBarColorStart = Color.WHITE
                //  backgroundProgressBarColorEnd = Color.RED
                backgroundProgressBarColorDirection = CircularProgressBar.GradientDirection.TOP_TO_BOTTOM

                // Set Width
                progressBarWidth = 29f // in DP
                backgroundProgressBarWidth = 20f // in DP

                // Other
                roundBorder = true
                startAngle = 180f
                progressDirection = CircularProgressBar.ProgressDirection.TO_RIGHT
            }
            txt_result.text ="Your result is upto 80%...\nYou need Doctor attention."
        }
        if (key1.toString().toInt() ==55)
        {
            val circularProgressBar = findViewById<CircularProgressBar>(R.id.circularProgressBar)
            circularProgressBar.apply {
                // Set Progress
                progress = 100f
                // or with animation
                setProgressWithAnimation(55f, 3000) // =1s

                // Set Progress Max
                progressMax = 100f

                // Set ProgressBar Color
                progressBarColor = Color.BLUE
                // or with gradient
                progressBarColorStart = Color.parseColor("#13547a")
                progressBarColorEnd = Color.parseColor("#80d0c7")
                progressBarColorDirection = CircularProgressBar.GradientDirection.RIGHT_TO_LEFT

                // Set background ProgressBar Color
                backgroundProgressBarColor = Color.GRAY
                // or with gradient
                //   backgroundProgressBarColorStart = Color.WHITE
                //  backgroundProgressBarColorEnd = Color.RED
                backgroundProgressBarColorDirection = CircularProgressBar.GradientDirection.TOP_TO_BOTTOM

                // Set Width
                progressBarWidth = 29f // in DP
                backgroundProgressBarWidth = 20f // in DP

                // Other
                roundBorder = true
                startAngle = 180f
                progressDirection = CircularProgressBar.ProgressDirection.TO_RIGHT
            }
            txt_result.text ="Your result is upto 55%...\nYou need Doctor attention."
        }
        if (key1.toString().toInt() ==60)
        {
            val circularProgressBar = findViewById<CircularProgressBar>(R.id.circularProgressBar)
            circularProgressBar.apply {
                // Set Progress
                progress = 100f
                // or with animation
                setProgressWithAnimation(60f, 3000) // =1s

                // Set Progress Max
                progressMax = 100f

                // Set ProgressBar Color
                progressBarColor = Color.BLUE
                // or with gradient
                progressBarColorStart = Color.parseColor("#13547a")
                progressBarColorEnd = Color.parseColor("#80d0c7")
                progressBarColorDirection = CircularProgressBar.GradientDirection.RIGHT_TO_LEFT

                // Set background ProgressBar Color
                backgroundProgressBarColor = Color.GRAY
                // or with gradient
                //   backgroundProgressBarColorStart = Color.WHITE
                //  backgroundProgressBarColorEnd = Color.RED
                backgroundProgressBarColorDirection = CircularProgressBar.GradientDirection.TOP_TO_BOTTOM

                // Set Width
                progressBarWidth = 29f // in DP
                backgroundProgressBarWidth = 20f // in DP

                // Other
                roundBorder = true
                startAngle = 180f
                progressDirection = CircularProgressBar.ProgressDirection.TO_RIGHT
            }
            txt_result.text ="Your result is upto 60%... chance\nYou need Doctor attention."
        }
        if (key1.toString().toInt() ==0)
        {
            val circularProgressBar = findViewById<CircularProgressBar>(R.id.circularProgressBar)
            circularProgressBar.apply {
                // Set Progress
                progress = 100f
                // or with animation
                setProgressWithAnimation(3f, 3000) // =1s

                // Set Progress Max
                progressMax = 100f

                // Set ProgressBar Color
                progressBarColor = Color.BLUE
                // or with gradient
                progressBarColorStart = Color.parseColor("#13547a")
                progressBarColorEnd = Color.parseColor("#80d0c7")
                progressBarColorDirection = CircularProgressBar.GradientDirection.RIGHT_TO_LEFT

                // Set background ProgressBar Color
                backgroundProgressBarColor = Color.GRAY
                // or with gradient
                //   backgroundProgressBarColorStart = Color.WHITE
                //  backgroundProgressBarColorEnd = Color.RED
                backgroundProgressBarColorDirection = CircularProgressBar.GradientDirection.TOP_TO_BOTTOM

                // Set Width
                progressBarWidth = 29f // in DP
                backgroundProgressBarWidth = 20f // in DP

                // Other
                roundBorder = true
                startAngle = 180f
                progressDirection = CircularProgressBar.ProgressDirection.TO_RIGHT
            }
            txt_result.text ="0% result...... please stay home...."
        }

    }
}
