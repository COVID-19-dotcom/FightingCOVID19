package com.example.fightingcovi_19

data class RegisterUserDataClass(var username:String,var dob:String,var gender:String, var age:String, var email:String,
                                 var address:String, var pincode:String, var mobile:String, var optional_mobile:String,
                                 var password: String) {

    constructor():this("","","","","","","","","","")

}