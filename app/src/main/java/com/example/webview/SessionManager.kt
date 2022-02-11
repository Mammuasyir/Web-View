package com.example.webview

import android.content.Context
import android.content.SharedPreferences

class SessionManager(context: Context) {

    var sharedPreferences : SharedPreferences? = null
    var editor : SharedPreferences.Editor? = null

//variabel key
    val keyPrefences = "Login"
    val keyName = "Name"
    val keyEmail = "Email"

    init {
        sharedPreferences = context.getSharedPreferences(keyPrefences,Context.MODE_PRIVATE)
        editor = sharedPreferences?.edit()
    }

//Session login

    fun sessionLogin(name: String, email: String) {
        editor?.putString(keyName, name)
        editor?.putString(keyEmail, email)
        editor?.apply()
    }

    fun sessionLogout(){
        editor?.remove(keyName)
        editor?.remove(keyEmail)
        editor?.apply()
    }

//kondisi login atau tidak
    val name : String?
        get() = sharedPreferences?.getString(keyName, null)
    val email : String?
        get() = sharedPreferences?.getString(keyEmail, null)

    fun isiLogin(): Boolean{
        if(!name.isNullOrEmpty() && !email.isNullOrEmpty()){
            return true
        }
        return false
    }

}