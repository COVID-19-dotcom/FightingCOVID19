package com.example.fightingcovi_19

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_regster_user.*

class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        floatButtonLogin.setOnClickListener {
            floatButtonLogin.visibility = View.GONE
            pbLoginProgress.visibility = View.VISIBLE
            var flag = false
            var email = ""
            var user = ""
            val firebaseRef = FirebaseDatabase.getInstance().getReference("Login")
            firebaseRef.addValueEventListener(object : ValueEventListener{
                override fun onCancelled(p0: DatabaseError) {
                    Toast.makeText(applicationContext,"Failed to Connect to Server",Toast.LENGTH_LONG).show()
                }
                override fun onDataChange(p0: DataSnapshot) {
                    for(snap in p0.children){
                        val value = snap.getValue(RegisterUserDataClass::class.java)
                        if(value!!.email == edtLoginUsername.text.toString() || value!!.password == edtLoginPassword.text.toString()){
                            email = value.email
                            user = value.username
                            flag = true
                            break
                        }
                    }
                    if(flag){
                        val pref = getSharedPreferences("Login",Context.MODE_PRIVATE)
                        val edit = pref.edit()
                        edit.putString("username",user)
                        edit.putString("email",email)
                        edit.putString("type","user")
                        edit.apply()
                        startActivity(Intent(this@Login,UserDashboard::class.java))
                        finish()
                    }else{
                        error_msg.error = "Invalid Username or Password!!"
                        floatButtonLogin.visibility = View.VISIBLE
                        pbLoginProgress.visibility = View.GONE
                    }
                }
            })
        }

        txtGotoSignUp.setOnClickListener {
            startActivity(Intent(this,RegsterUser::class.java))
        }

    }
}
