package com.baharudin.traveladmin.util

import android.content.Context
import android.content.SharedPreferences

class Preference(context: Context) {

    companion object {
        const val ADMIN_PREF = "ADMIN_PREF"
    }
    val sharedPreference = context.getSharedPreferences(ADMIN_PREF,0)

    fun setData(key : String,value : String ) {
        val editor : SharedPreferences.Editor = sharedPreference.edit()
        editor.putString(key, value)
        editor.apply()
    }
    fun getData(key: String) : String? {
        return sharedPreference.getString(key,"")
    }
}