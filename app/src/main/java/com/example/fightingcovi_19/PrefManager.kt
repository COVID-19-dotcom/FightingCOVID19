package com.example.fightingcovi_19

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity

class PrefManager {

    lateinit var con : Context
    lateinit var pref : SharedPreferences

    constructor(con: Context) {
        this.con = con
        getSP()
    }

    private fun getSP() {
        pref = con.getSharedPreferences(con.getString(R.string.Pref_name),Context.MODE_PRIVATE)
    }

    fun writeSP()
    {
        var editor : SharedPreferences.Editor = pref.edit()
        editor.putString(con.getString(R.string.pref_key),"NEXT")
        editor.commit()
    }

    fun checkPreference() : Boolean
    {
        var status : Boolean = false
        status = !pref.getString(con.getString(R.string.pref_key),"null").equals("null")
        return status
    }

    fun clearPrefernce()
    {
        pref.edit().clear().commit()

        con.startActivity(Intent(con,AppIntro::class.java))
        (con as AppCompatActivity).finish()
    }
}