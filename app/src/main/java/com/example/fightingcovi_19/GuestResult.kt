package com.example.fightingcovi_19

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mikhaellopez.circularprogressbar.CircularProgressBar
import kotlinx.android.synthetic.main.activity_guest_result.*

class GuestResult : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guest_result)

        check1()
        imgbutton1.setOnClickListener {
            var intent = Intent(this, GuestTesting::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun check1() {
        var intentkey1 = intent
        val key1 = intentkey1.getStringExtra("key1")
        if (key1.toString().toInt() == 75) {
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
                progressBarColorStart = Color.parseColor("#0E8E04")
                progressBarColorEnd = Color.parseColor("#052798")
                progressBarColorDirection = CircularProgressBar.GradientDirection.RIGHT_TO_LEFT

                // Set background ProgressBar Color
                backgroundProgressBarColor = Color.GRAY
                // or with gradient
                //   backgroundProgressBarColorStart = Color.WHITE
                //  backgroundProgressBarColorEnd = Color.RED
                backgroundProgressBarColorDirection =
                    CircularProgressBar.GradientDirection.TOP_TO_BOTTOM

                // Set Width
                progressBarWidth = 29f // in DP
                backgroundProgressBarWidth = 20f // in DP

                // Other
                roundBorder = true
                startAngle = 180f
                progressDirection = CircularProgressBar.ProgressDirection.TO_RIGHT
            }
            txt_result1.text = "Your result is upto 75%...\nYou need Doctor attention."
        }
        if (key1.toString().toInt() == 70) {
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
                progressBarColorStart = Color.parseColor("#0E8E04")
                progressBarColorEnd = Color.parseColor("#052798")
                progressBarColorDirection = CircularProgressBar.GradientDirection.RIGHT_TO_LEFT

                // Set background ProgressBar Color
                backgroundProgressBarColor = Color.GRAY
                // or with gradient
                //   backgroundProgressBarColorStart = Color.WHITE
                //  backgroundProgressBarColorEnd = Color.RED
                backgroundProgressBarColorDirection =
                    CircularProgressBar.GradientDirection.TOP_TO_BOTTOM

                // Set Width
                progressBarWidth = 29f // in DP
                backgroundProgressBarWidth = 20f // in DP

                // Other
                roundBorder = true
                startAngle = 180f
                progressDirection = CircularProgressBar.ProgressDirection.TO_RIGHT
            }
            txt_result1.text = "Your result is upto 70%...\nYou need Doctor attention."
        }
        if (key1.toString().toInt() == 80) {
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
                progressBarColorStart = Color.parseColor("#0E8E04")
                progressBarColorEnd = Color.parseColor("#052798")
                progressBarColorDirection = CircularProgressBar.GradientDirection.RIGHT_TO_LEFT

                // Set background ProgressBar Color
                backgroundProgressBarColor = Color.GRAY
                // or with gradient
                //   backgroundProgressBarColorStart = Color.WHITE
                //  backgroundProgressBarColorEnd = Color.RED
                backgroundProgressBarColorDirection =
                    CircularProgressBar.GradientDirection.TOP_TO_BOTTOM

                // Set Width
                progressBarWidth = 29f // in DP
                backgroundProgressBarWidth = 20f // in DP

                // Other
                roundBorder = true
                startAngle = 180f
                progressDirection = CircularProgressBar.ProgressDirection.TO_RIGHT
            }
            txt_result1.text = "Your result is upto 80%...\nYou need Doctor attention."
        }
        if (key1.toString().toInt() == 55) {
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
                progressBarColorStart = Color.parseColor("#0E8E04")
                progressBarColorEnd = Color.parseColor("#052798")
                progressBarColorDirection = CircularProgressBar.GradientDirection.RIGHT_TO_LEFT

                // Set background ProgressBar Color
                backgroundProgressBarColor = Color.GRAY
                // or with gradient
                //   backgroundProgressBarColorStart = Color.WHITE
                //  backgroundProgressBarColorEnd = Color.RED
                backgroundProgressBarColorDirection =
                    CircularProgressBar.GradientDirection.TOP_TO_BOTTOM

                // Set Width
                progressBarWidth = 29f // in DP
                backgroundProgressBarWidth = 20f // in DP

                // Other
                roundBorder = true
                startAngle = 180f
                progressDirection = CircularProgressBar.ProgressDirection.TO_RIGHT
            }
            txt_result1.text = "Your result is upto 55%...\nYou need Doctor attention."
        }
        if (key1.toString().toInt() == 60) {
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
                progressBarColorStart = Color.parseColor("#0E8E04")
                progressBarColorEnd = Color.parseColor("#052798")
                progressBarColorDirection = CircularProgressBar.GradientDirection.RIGHT_TO_LEFT

                // Set background ProgressBar Color
                backgroundProgressBarColor = Color.GRAY
                // or with gradient
                //   backgroundProgressBarColorStart = Color.WHITE
                //  backgroundProgressBarColorEnd = Color.RED
                backgroundProgressBarColorDirection =
                    CircularProgressBar.GradientDirection.TOP_TO_BOTTOM

                // Set Width
                progressBarWidth = 29f // in DP
                backgroundProgressBarWidth = 20f // in DP

                // Other
                roundBorder = true
                startAngle = 180f
                progressDirection = CircularProgressBar.ProgressDirection.TO_RIGHT
            }
            txt_result1.text = "Your result is upto 60%... chance\nYou need Doctor attention."
        }
        if (key1.toString().toInt() == 0) {
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
                progressBarColorStart = Color.parseColor("#0E8E04")
                progressBarColorEnd = Color.parseColor("#052798")
                progressBarColorDirection = CircularProgressBar.GradientDirection.RIGHT_TO_LEFT

                // Set background ProgressBar Color
                backgroundProgressBarColor = Color.GRAY
                // or with gradient
                //   backgroundProgressBarColorStart = Color.WHITE
                //  backgroundProgressBarColorEnd = Color.RED
                backgroundProgressBarColorDirection =
                    CircularProgressBar.GradientDirection.TOP_TO_BOTTOM

                // Set Width
                progressBarWidth = 29f // in DP
                backgroundProgressBarWidth = 20f // in DP

                // Other
                roundBorder = true
                startAngle = 180f
                progressDirection = CircularProgressBar.ProgressDirection.TO_RIGHT
            }
            txt_result1.text = "0% result..... please stay home...."
        }
    }
}
