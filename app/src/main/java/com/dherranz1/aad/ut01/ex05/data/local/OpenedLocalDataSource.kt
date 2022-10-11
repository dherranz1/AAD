package com.dherranz1.aad.ut01.ex05.data.local

import android.content.SharedPreferences
import android.util.Log
import com.dherranz1.aad.ut01.ex05.data.remote.models.UserApiModel
import com.google.gson.Gson

class OpenedLocalDataSource(private val sharedPreferences: SharedPreferences) {

    private val keyName = "contador"
    private val editor: SharedPreferences.Editor = sharedPreferences.edit()


    fun updateCounter() : Int{
        if (getCounter() == 0)
            saveFirstOpen()
        else
            addOpen()

        return getCounter()
    }

    private fun saveFirstOpen(){
        editor.putInt(keyName, 1)
        editor.apply()
    }

    private fun addOpen(){
        val counter = getCounter()

        editor.putInt(keyName, (counter+1))
        editor.apply()
    }

    fun getCounter(): Int =
        sharedPreferences.getInt(keyName, 0)


    fun removeCounter() =
        editor.remove(keyName).apply()


}