package com.example.fightingcovi_19

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_guest_testing.*
import kotlinx.android.synthetic.main.activity_user_dashboard.*

class GuestTesting : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guest_testing)
        pb_CheckCorona.visibility = View.INVISIBLE

        rd_FeverMore96.isEnabled = false
        rd_FeverMore98.isEnabled = false
        rd_FeverMore102.isEnabled = false
        rd_FeverNone.isEnabled = false
        edt_FeverDays.isEnabled = false

        rd_CoughDry.isEnabled = false
        rd_CoughGel.isEnabled = false
        edt_CoughDays.isEnabled = false

        edt_LowSmellDays.isEnabled = false
        edt_SoreThroatDays.isEnabled = false
        edt_FeelingNotWellDays.isEnabled = false
        edt_ChangeInAppetiteDays.isEnabled = false
        edt_DifficultyInBreathingDays.isEnabled = false
        edt_PersistantPainDays.isEnabled = false
        edt_DrowsinessDays.isEnabled = false

        edt_TravelHistory.isEnabled = false

        chk_ButtonFever.setOnCheckedChangeListener { buttonView, isChecked ->
            if (chk_ButtonFever.isChecked == true) {
                rd_FeverMore96.isEnabled = true
                rd_FeverMore98.isEnabled = true
                rd_FeverMore102.isEnabled = true
                rd_FeverNone.isEnabled = true
                rd_ButtonFever.setOnCheckedChangeListener { group, checkedId ->
                    when (checkedId) {
                        R.id.rd_FeverMore96 -> {
                            runOnUiThread {
                                Toast.makeText(this, rd_FeverMore96.text, Toast.LENGTH_LONG).show()
                                edt_FeverDays.isEnabled = true
                            }
                        }
                        R.id.rd_FeverMore98 -> {
                            runOnUiThread {
                                Toast.makeText(this, rd_FeverMore98.text, Toast.LENGTH_LONG).show()
                                edt_FeverDays.isEnabled = true
                            }
                        }
                        R.id.rd_FeverMore102 -> {
                            runOnUiThread {
                                Toast.makeText(this, rd_FeverMore102.text, Toast.LENGTH_LONG).show()
                                edt_FeverDays.isEnabled = true
                            }
                        }
                        R.id.rd_FeverNone -> {
                            runOnUiThread {
                                Toast.makeText(this, rd_FeverNone.text, Toast.LENGTH_LONG).show()
                            }
                        }
                    }
                }
            } else {
                rd_FeverMore96.isChecked = false
                rd_FeverMore98.isChecked = false
                rd_FeverMore102.isChecked = false
                rd_FeverNone.isChecked = false
                edt_FeverDays.setText("")
                rd_FeverMore96.isEnabled = false
                rd_FeverMore98.isEnabled = false
                rd_FeverMore102.isEnabled = false
                rd_FeverNone.isEnabled = false
                edt_FeverDays.isEnabled = false


            }
        }

        chk_ButtonCough.setOnCheckedChangeListener { group, checkedId ->
            if (chk_ButtonCough.isChecked == true) {
                rd_CoughDry.isEnabled = true
                rd_CoughGel.isEnabled = true
                rd_ButtonCough.setOnCheckedChangeListener { group, checkedId ->
                    when (checkedId) {
                        R.id.rd_CoughDry -> {
                            runOnUiThread {
                                Toast.makeText(this, rd_CoughDry.text, Toast.LENGTH_LONG).show()
                                edt_CoughDays.isEnabled = true
                            }
                        }
                        R.id.rd_CoughGel -> {
                            runOnUiThread {
                                Toast.makeText(this, rd_CoughGel.text, Toast.LENGTH_LONG).show()
                                edt_CoughDays.isEnabled = true
                            }
                        }
                    }
                }
            } else {
                rd_CoughDry.isChecked = false
                rd_CoughGel.isChecked = false
                edt_CoughDays.setText("")
                rd_CoughDry.isEnabled = false
                rd_CoughGel.isEnabled = false
                edt_CoughDays.isEnabled = false
            }
        }

        chk_ButtonLowSmell.setOnCheckedChangeListener { buttonView, isChecked ->
            if (chk_ButtonLowSmell.isChecked == true) {
                edt_LowSmellDays.isEnabled = true
            } else {
                edt_LowSmellDays.isEnabled = false
                edt_LowSmellDays.setText("")
            }
        }

        chk_ButtonSoreThroat.setOnCheckedChangeListener { buttonView, isChecked ->
            if (chk_ButtonSoreThroat.isChecked == true) {
                edt_SoreThroatDays.isEnabled = true
            } else {
                edt_SoreThroatDays.isEnabled = false
                edt_SoreThroatDays.setText("")
            }
        }

        chk_ButtonFeelingNotWell.setOnCheckedChangeListener { buttonView, isChecked ->
            if (chk_ButtonFeelingNotWell.isChecked == true) {
                edt_FeelingNotWellDays.isEnabled = true
            } else {
                edt_FeelingNotWellDays.isEnabled = false
                edt_FeelingNotWellDays.setText("")
            }
        }

        chk_ButtonChangeInAppetite.setOnCheckedChangeListener { buttonView, isChecked ->
            if (chk_ButtonChangeInAppetite.isChecked == true) {
                edt_ChangeInAppetiteDays.isEnabled = true
            } else {
                edt_ChangeInAppetiteDays.isEnabled = false
                edt_ChangeInAppetiteDays.setText("")
            }
        }

        chk_ButtonDifficultyInBreathing.setOnCheckedChangeListener { buttonView, isChecked ->
            if (chk_ButtonDifficultyInBreathing.isChecked == true) {
                edt_DifficultyInBreathingDays.isEnabled = true
            } else {
                edt_DifficultyInBreathingDays.isEnabled = false
                edt_DifficultyInBreathingDays.setText("")
            }
        }

        chk_ButtonPersistantPain.setOnCheckedChangeListener { buttonView, isChecked ->
            if (chk_ButtonPersistantPain.isChecked == true) {
                edt_PersistantPainDays.isEnabled = true
            } else {
                edt_PersistantPainDays.isEnabled = false
                edt_PersistantPainDays.setText("")
            }
        }

        chk_ButtonDrowsiness.setOnCheckedChangeListener { buttonView, isChecked ->
            if (chk_ButtonDrowsiness.isChecked == true) {
                edt_DrowsinessDays.isEnabled = true
            } else {
                edt_DrowsinessDays.isEnabled = false
                edt_DrowsinessDays.setText("")
            }
        }

        chk_ButtonTravelHistory.setOnCheckedChangeListener { buttonView, isChecked ->
            if (chk_ButtonTravelHistory.isChecked == true) {
                edt_TravelHistory.isEnabled = true
            } else {
                edt_TravelHistory.isEnabled = false
                edt_TravelHistory.setText("")
            }
        }

        btn_CheckCorona.setOnClickListener {
            btn_CheckCorona.visibility = View.INVISIBLE
            pb_CheckCorona.visibility = View.VISIBLE
            var builder = AlertDialog.Builder(this)
            builder.setIcon(android.R.drawable.ic_dialog_alert)
            builder.setTitle("Alert Dailog")
            builder.setMessage("Your Data has been submitted successfully.")
            builder.setNegativeButton("Done", { dialog, which ->
                val snackbar = Snackbar.make(it, "Submitted.", Snackbar.LENGTH_LONG)
                snackbar.show()
                edt_GuestUsername.setText("")
                edt_GuestMobile.setText("")
                pb_CheckCorona.visibility = View.INVISIBLE
                btn_CheckCorona.visibility = View.VISIBLE

                CoronaActive()
            })
            builder.setCancelable(false)
            var dialog = builder.create()
            dialog.show()
        }

        txtButtonLogin.setOnClickListener {
            startActivity(Intent(this, Login::class.java))
        }

    }
    fun CoronaActive()
    {
        if(rd_FeverMore98.isChecked || rd_FeverMore102.isChecked && (edt_FeverDays.text.toString().toInt()>=3) &&
            rd_CoughDry.isChecked && (edt_CoughDays.text.toString().toInt()>=3) && chk_ButtonDifficultyInBreathing.isChecked)
        {
            var string="75"
            var intent=Intent(this,GuestResult::class.java)
            intent.putExtra("key1",string)
            startActivity(intent)

        }
        else
            if(rd_FeverMore98.isChecked || rd_FeverMore102.isChecked && (edt_FeverDays.text.toString().toInt()>=3) &&
                rd_CoughDry.isChecked && (edt_CoughDays.text.toString().toInt()>=3) && chk_ButtonPersistantPain.isChecked &&
                (edt_PersistantPainDays.text.toString().toInt()>=1))
            {
                var string="70"
                var intent=Intent(this,GuestResult::class.java)
                intent.putExtra("key1",string)
                startActivity(intent)

            }
            else
                if(rd_FeverMore98.isChecked || rd_FeverMore102.isChecked && (edt_FeverDays.text.toString().toInt()>=3) &&
                    rd_CoughDry.isChecked && (edt_CoughDays.text.toString().toInt()>=3) && chk_ButtonSoreThroat.isChecked &&
                    chk_Diabetes.isChecked || chk_HighBloodPressure.isChecked
                    || chk_DiabetesHeartDisease.isChecked)
                {
                    var string="80"
                    var intent=Intent(this,GuestResult::class.java)
                    intent.putExtra("key1",string)
                    startActivity(intent)

                }
                else
                    if( chk_ButtonFeelingNotWell.isChecked && chk_Diabetes.isChecked || chk_HighBloodPressure.isChecked
                        || chk_DiabetesHeartDisease.isChecked)
                    {
                        var string="55"
                        var intent=Intent(this,GuestResult::class.java)
                        intent.putExtra("key1",string)
                        startActivity(intent)

                    }
                    else
                        if(chk_ButtonTravelHistory.isChecked)
                        {
                            var string="60"
                            var intent=Intent(this,GuestResult::class.java)
                            intent.putExtra("key1",string)
                            startActivity(intent)

                        }
                        else
                        {
                            var string="0"
                            var intent=Intent(this,GuestResult::class.java)
                            intent.putExtra("key1",string)
                            startActivity(intent)

                        }
    }

}
