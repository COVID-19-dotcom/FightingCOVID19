package com.example.fightingcovi_19

import android.R.attr.data
import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.common.util.Hex
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_regster_user.*
import java.util.*


class RegsterUser : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regster_user)
        edtRegUserDate.setOnClickListener {
            val cal= Calendar.getInstance()
            val year=cal.get(Calendar.YEAR)
            val month=cal.get(Calendar.MONTH)
            val day=cal.get(Calendar.DATE)
            var dd=""
            var mm=""
            val datepicker= DatePickerDialog(this,{ view, year, month, dayOfMonth ->
                when {
                    dayOfMonth < 10 -> dd = "0$dayOfMonth"
                    (month + 1) < 10 -> mm = "0" + (month + 10)
                    else -> mm = "" + (month + 1)
                }
                edtRegUserDate.setText(""+dayOfMonth + "/" + (month+1) + "/" + year)
            },year,month,day)
            datepicker.show()
        }

        btnRegisterrNewUser.setOnClickListener {
            if(validateUsername()){
                edtRegUserNameError.isErrorEnabled = false
                        if(validateAge()){
                            edtRegUserAgeError.isErrorEnabled = false
                            if(validateEmail()){
                                edtRegUserEmailError.isErrorEnabled = false
                                if(validateAdd()){
                                    edtRegUserAddError.isErrorEnabled = false
                                    if(validatePin()){
                                        edtRegUserPincodeError.isErrorEnabled = false
                                        if(validateMobile()){
                                            edtRegUserMobileError.isErrorEnabled = false
                                            if(validateOpMobile()){
                                                edtRegUserOpError.isErrorEnabled = false
                                                if(validatePass()){
                                                    edtRegUserConPassError.isErrorEnabled = false
                                                    registerUser()
                                                }else{
                                                    edtRegUserConPassError.error = "Enter Password"
                                                }
                                            }else{
                                                edtRegUserOpError.error = "Enter Optional Mobile No."
                                            }
                                        }else{
                                            edtRegUserMobileError.error = "Enter Mobile No."
                                        }
                                    }else{
                                        edtRegUserPincodeError.error = "Enter Pincode"
                                    }
                                }else{
                                    edtRegUserAddError.error = "Enter Address"
                                }
                            }else{
                                edtRegUserEmailError.error = "Enter Email"
                            }
                        }else {
                            edtRegUserAgeError.error = "Enter Age"
                        }
            }else{
                edtRegUserNameError.error = "Username is Required!!"
            }
        }
    }

    private fun registerUser() {
        btnRegisterrNewUser.visibility = View.GONE
        pbRegUser.visibility = View.VISIBLE
        val firebaseRef = FirebaseDatabase.getInstance().getReference("Login")
        var gen = ""
        gen = if(rdRegUserFemale.isChecked)
            "Female"
        else if(rdRegUserMale.isChecked)
            "Male"
        else
            "NA"
        firebaseRef.push()
            .setValue(RegisterUserDataClass(edtRegUserName.text.toString(),edtRegUserDate.text.toString(),gen,
            edtRegUserAge.text.toString(),edtRegUserEmail.text.toString(),edtRegUserAdd.text.toString(),edtRegUserPincode.text.toString(),
            edtRegUserMobile.text.toString(),edtRegUserOpMobile.text.toString(),edtRegUserPass.text.toString()))
            .addOnFailureListener {
                Toast.makeText(applicationContext,"Failed to Connect to Server",Toast.LENGTH_LONG).show()
                btnRegisterrNewUser.visibility = View.VISIBLE
                pbRegUser.visibility = View.GONE
            }.addOnSuccessListener {
                val pref = getSharedPreferences("Login",Context.MODE_PRIVATE)
                val edit = pref.edit()
                edit.putString("username",edtRegUserName.text.toString())
                edit.putString("email",edtRegUserEmail.text.toString())
                edit.putString("type","user")
                edit.apply()
                startActivity(Intent(this,UserDashboard::class.java))
            }
    }

    private fun validateUsername() : Boolean{
        return edtRegUserName.text.toString().isNotEmpty()
    }

    private fun validateDate() : Boolean{
        return edtRegUserDate.text.toString() == "Date Of Birth"
    }

    private fun validateGender() : Boolean{
        return when {
            rdRegUserMale.isChecked -> {
                false
            }
            rdRegUserFemale.isChecked -> {
                false
            }
            else -> {
                true
            }
        }
    }

    private fun validateAge() : Boolean{
        return edtRegUserAge.text.toString().isNotEmpty()
    }

    private fun validateEmail() : Boolean{
        return edtRegUserEmail.text.toString().isNotEmpty()
    }
    private fun validateAdd() : Boolean{
        return edtRegUserAdd.text.toString().isNotEmpty()
    }
    private fun validatePin() : Boolean{
        return edtRegUserPincode.text.toString().isNotEmpty()
    }
    private fun validateMobile() : Boolean{
        return edtRegUserMobile.text.toString().isNotEmpty()
    }
    private fun validateOpMobile() : Boolean{
        return edtRegUserOpMobile.text.toString().isNotEmpty()
    }
    private fun validatePass() : Boolean{
        return edtRegUserPass.text.toString().isNotEmpty()
    }
}
