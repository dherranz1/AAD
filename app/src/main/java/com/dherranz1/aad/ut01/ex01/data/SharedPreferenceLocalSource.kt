package com.dherranz1.aad.ut01.ex01.data

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.dherranz1.aad.R
import com.dherranz1.aad.ut01.ex01.domain.Customer

class SharedPreferenceLocalSource(val activity: AppCompatActivity) {

    val sharedPref = activity.getSharedPreferences(activity.getString(R.string.preference_ut01ex01), Context.MODE_PRIVATE)

    fun saveCustomer(customer: Customer){
        val editor = sharedPref.edit()
        editor.putInt("id", customer.id)
        editor.putString("name", customer.name)
        editor.putString("surname", customer.surname)
        editor.putBoolean("is_active", customer.isActive)

        editor.apply() // asincrono
        //editor.commit() sincrono
    }

}