package com.example.fightingcovi_19

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_user_dashboard.*
import kotlinx.android.synthetic.main.activity_user_profile.*
import kotlinx.android.synthetic.main.activity_user_profile.navigator

class UserProfile : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)

        navigator.setItemSelected(R.id.profile,true)

        val firebaseRef = FirebaseDatabase.getInstance().getReference("Login")
        val pref = getSharedPreferences("Login",Context.MODE_PRIVATE)
        firebaseRef.addValueEventListener(object : ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {
                Toast.makeText(applicationContext,"Failed to Connect with Server!!",Toast.LENGTH_LONG)
            }

            override fun onDataChange(p0: DataSnapshot) {
                for(snap in p0.children){
                    val value = snap.getValue(RegisterUserDataClass::class.java)
                    if(value!!.email == pref.getString("email",null)){
                        txtUsername.text = pref.getString("username",null)
                        txtUserEmailAdd.text = pref.getString("email",null)
                        txtUserMobileNo.text = value.mobile
                        txtUserOptinalMobileNum.text = value.optional_mobile
                        txtUserAge.text = value.age
                        txtUserGender.text = value.gender
                        txtUserAddress.text = "${value.address} - ${value.pincode}"
                    }
                }
            }

        })


        Handler().postDelayed({
            mainLayout.visibility = View.VISIBLE
            progressLayout.visibility = View.GONE
        },3000)


        navigator.setOnItemSelectedListener {
            if(it==R.id.home)
            {
                var intent= Intent(this,UserDashboard::class.java)
                startActivity(intent)
                finish()

            }
            if (it==R.id.nearby)
            {
                var intent= Intent(this,CoronaInfo::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}
