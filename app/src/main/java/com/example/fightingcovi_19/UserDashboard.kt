package com.example.fightingcovi_19

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_corona_info.*
import kotlinx.android.synthetic.main.activity_guest_testing.*
import kotlinx.android.synthetic.main.activity_user_dashboard.*

class UserDashboard : AppCompatActivity() {

    lateinit var pref : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_dashboard)
        navigator.setItemSelected(R.id.home,true)

        pref = getSharedPreferences("Login",Context.MODE_PRIVATE)

        txtButtonLogout.setOnClickListener {
            val edit = pref.edit()
            edit.clear()
            edit.apply()
            startActivity(Intent(this,Login::class.java))
            finish()
        }

        txtWelcomeText.text = "Welcome, ${pref.getString("username",null)}"


        pbUserCheckCorona.visibility = View.INVISIBLE

        rdFeverMore96.isEnabled = false
        rdFeverMore98.isEnabled = false
        rdFeverMore102.isEnabled = false
        rdFeverNone.isEnabled = false
        edtFeverDays.isEnabled = false

        rdCoughDry.isEnabled = false
        rdCoughGel.isEnabled = false
        edtCoughDays.isEnabled = false

        edtLowSmellDays.isEnabled = false
        edtSoreThroatDays.isEnabled = false
        edtFeelingNotWellDays.isEnabled=false
        edtChangeInAppetiteDays.isEnabled= false
        edtDifficultyInBreathingDays.isEnabled= false
        edtPersistantPainDays.isEnabled= false
        edtDrowsinessDays.isEnabled= false

        edtTravelHistory.isEnabled=false

        chkButtonFever.setOnCheckedChangeListener { buttonView, isChecked ->
            if(chkButtonFever.isChecked==true)
            {
                rdFeverMore96.isEnabled = true
                rdFeverMore98.isEnabled = true
                rdFeverMore102.isEnabled = true
                rdFeverNone.isEnabled = true
                rdButtonFever.setOnCheckedChangeListener { group, checkedId ->
                    when(checkedId){
                        R.id.rdFeverMore96->{
                            runOnUiThread {
                                Toast.makeText(this,rdFeverMore96.text, Toast.LENGTH_LONG).show()
                                edtFeverDays.isEnabled = true
                            }
                        }
                        R.id.rdFeverMore98->{
                            runOnUiThread {
                                Toast.makeText(this,rdFeverMore98.text, Toast.LENGTH_LONG).show()
                                edtFeverDays.isEnabled = true
                            }
                        }
                        R.id.rdFeverMore102->{
                            runOnUiThread {
                                Toast.makeText(this,rdFeverMore102.text, Toast.LENGTH_LONG).show()
                                edtFeverDays.isEnabled = true
                            }
                        }
                        R.id.rdFeverNone->{
                            runOnUiThread {
                                Toast.makeText(this,rdFeverNone.text, Toast.LENGTH_LONG).show()
                            }
                        }
                    }
                }
            }
            else
            {
                rdFeverMore96.isChecked = false
                rdFeverMore98.isChecked = false
                rdFeverMore102.isChecked = false
                rdFeverNone.isChecked = false
                edtFeverDays.setText("")
                rdFeverMore96.isEnabled = false
                rdFeverMore98.isEnabled = false
                rdFeverMore102.isEnabled = false
                rdFeverNone.isEnabled = false
                edtFeverDays.isEnabled = false


            }
        }

        chkButtonCough.setOnCheckedChangeListener { group, checkedId ->
            if(chkButtonCough.isChecked==true)
            {
                rdCoughDry.isEnabled = true
                rdCoughGel.isEnabled = true
                rdButtonCough.setOnCheckedChangeListener { group, checkedId ->
                    when (checkedId) {
                        R.id.rdCoughDry -> {
                            runOnUiThread {
                                Toast.makeText(this, rdCoughDry.text, Toast.LENGTH_LONG).show()
                                edtCoughDays.isEnabled = true
                            }
                        }
                        R.id.rdCoughGel -> {
                            runOnUiThread {
                                Toast.makeText(this, rdCoughGel.text, Toast.LENGTH_LONG).show()
                                edtCoughDays.isEnabled = true
                            }
                        }
                    }
                }
            }
            else
            {
                rdCoughDry.isChecked = false
                rdCoughGel.isChecked = false
                edtCoughDays.setText("")
                rdCoughDry.isEnabled=false
                rdCoughGel.isEnabled=false
                edtCoughDays.isEnabled=false
            }
        }

        chkButtonLowSmell.setOnCheckedChangeListener { buttonView, isChecked ->
            if(chkButtonLowSmell.isChecked==true)
            {
                edtLowSmellDays.isEnabled = true
            }
            else
            {
                edtLowSmellDays.isEnabled = false
                edtLowSmellDays.setText("")
            }
        }

        chkButtonSoreThroat.setOnCheckedChangeListener { buttonView, isChecked ->
            if(chkButtonSoreThroat.isChecked==true)
            {
                edtSoreThroatDays.isEnabled=true
            }
            else
            {
                edtSoreThroatDays.isEnabled=false
                edtSoreThroatDays.setText("")
            }
        }

        chkButtonFeelingNotWell.setOnCheckedChangeListener { buttonView, isChecked ->
            if(chkButtonFeelingNotWell.isChecked==true)
            {
                edtFeelingNotWellDays.isEnabled=true
            }
            else
            {
                edtFeelingNotWellDays.isEnabled=false
                edtFeelingNotWellDays.setText("")
            }
        }

        chkButtonChangeInAppetite.setOnCheckedChangeListener { buttonView, isChecked ->
            if(chkButtonChangeInAppetite.isChecked==true)
            {
                edtChangeInAppetiteDays.isEnabled=true
            }
            else
            {
                edtChangeInAppetiteDays.isEnabled= false
                edtChangeInAppetiteDays.setText("")
            }
        }

        chkButtonDifficultyInBreathing.setOnCheckedChangeListener { buttonView, isChecked ->
            if(chkButtonDifficultyInBreathing.isChecked==true)
            {
                edtDifficultyInBreathingDays.isEnabled=true
            }
            else
            {
                edtDifficultyInBreathingDays.isEnabled= false
                edtDifficultyInBreathingDays.setText("")
            }
        }

        chkButtonPersistantPain.setOnCheckedChangeListener { buttonView, isChecked ->
            if(chkButtonPersistantPain.isChecked==true)
            {
                edtPersistantPainDays.isEnabled=true
            }
            else
            {
                edtPersistantPainDays.isEnabled= false
                edtPersistantPainDays.setText("")
            }
        }

        chkButtonDrowsiness.setOnCheckedChangeListener { buttonView, isChecked ->
            if(chkButtonDrowsiness.isChecked==true)
            {
                edtDrowsinessDays.isEnabled=true
            }
            else
            {
                edtDrowsinessDays.isEnabled= false
                edtDrowsinessDays.setText("")
            }
        }

        chkButtonTravelHistory.setOnCheckedChangeListener { buttonView, isChecked ->
            if(chkButtonTravelHistory.isChecked==true)
            {
                edtTravelHistory.isEnabled=true
            }
            else
            {
                edtTravelHistory.isEnabled=false
                edtTravelHistory.setText("")
            }
        }

        btnUserCheckCorona.setOnClickListener {
            btnUserCheckCorona.visibility = View.INVISIBLE
            pbUserCheckCorona.visibility = View.VISIBLE
            var builder= AlertDialog.Builder(this)
            builder.setIcon(android.R.drawable.ic_dialog_alert)
            builder.setTitle("Alert Dailog")
            builder.setMessage("Your Data has been submitted successfully.")
            builder.setNegativeButton("Done",{dialog, which ->
                val snackbar= Snackbar.make(it,"Submitted.", Snackbar.LENGTH_LONG)
                snackbar.show()
                CoronaActive()
                edtDrNamename.setText("")
                edtDrMobile.setText("")
                pbUserCheckCorona.visibility = View.INVISIBLE
                btnUserCheckCorona.visibility = View.VISIBLE

            })
            builder.setCancelable(false)
            var dialog=builder.create()
            dialog.show()
        }


        navigator.setOnItemSelectedListener {
            if (it==R.id.nearby)
            {
                var intent=Intent(this,CoronaInfo::class.java)
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


    fun CoronaActive()
    {
        if(rdFeverMore98.isChecked || rdFeverMore102.isChecked && (edtFeverDays.text.toString().toInt()>=3) &&
            rdCoughDry.isChecked && (edtCoughDays.text.toString().toInt()>=3) && chkButtonDifficultyInBreathing.isChecked)
        {
            var string="75"
            var intent=Intent(this,UserResult::class.java)
            intent.putExtra("key1",string)
            startActivity(intent)

        }
        else
        if(rdFeverMore98.isChecked || rdFeverMore102.isChecked && (edtFeverDays.text.toString().toInt()>=3) &&
            rdCoughDry.isChecked && (edtCoughDays.text.toString().toInt()>=3) && chkButtonPersistantPain.isChecked &&
            (edtPersistantPainDays.text.toString().toInt()>=1))
        {
            var string="70"
            var intent=Intent(this,UserResult::class.java)
            intent.putExtra("key1",string)
            startActivity(intent)

        }
        else
        if(rdFeverMore98.isChecked || rdFeverMore102.isChecked && (edtFeverDays.text.toString().toInt()>=3) &&
            rdCoughDry.isChecked && (edtCoughDays.text.toString().toInt()>=3) && chkButtonSoreThroat.isChecked &&
            chkDiabetes.isChecked || chkHighBloodPressure.isChecked
            || chkDiabetesHeartDisease.isChecked)
        {
            var string="80"

            var intent=Intent(this,UserResult::class.java)
            intent.putExtra("key1",string)
            startActivity(intent)

        }
        else
        if( chkButtonFeelingNotWell.isChecked && chkDiabetes.isChecked || chkHighBloodPressure.isChecked
            || chkDiabetesHeartDisease.isChecked)
        {
            var string="55"
            var intent=Intent(this,UserResult::class.java)
            intent.putExtra("key1",string)
            startActivity(intent)

        }
        else
        if(chkButtonTravelHistory.isChecked)
        {
            var string="60"
            var intent=Intent(this,UserResult::class.java)
            intent.putExtra("key1",string)
            startActivity(intent)

        }
        else
        {
            var string="0"
            var m=edtDrMobile.text.toString()
            var intent=Intent(this,UserResult::class.java)
            intent.putExtra("key1",string)
            intent.putExtra("key2",m)
           startActivity(intent)

        }

    }
}
