package com.dherranz1.aad.ut01.ex01.data

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import com.dherranz1.aad.R
import com.dherranz1.aad.ut01.ex01.domain.Customer

abstract class PreferenceSource (activity: Activity) : IPreferencesSource {

    abstract var sharedPref : SharedPreferences

    override fun saveCustomer(customer: Customer){

        val editor = sharedPref.edit()

        // Java style
        // ===========
        editor.putInt("id", customer.id)
        editor.putString("name", customer.name)
        editor.putString("surname", customer.surname)
        editor.putBoolean("is_active", customer.isActive)

        editor.apply() // asincrono
        //editor.commit() sincrono

        // Kotlin style
        // ========================
        /*editor.apply{
            putInt("id", customer.id)
            putString("name", customer.name)
            putString("surname", customer.surname)
            putBoolean("is_active", customer.isActive)

            apply() // Es un apply diferente al de arriba
        }*/
    }

    override fun getCustomer() : Customer{

        return Customer(
            sharedPref.getInt("id",0),
            sharedPref.getString("name","no existe")!!, // Ignorar si es nulo asumiendo riesgos
            sharedPref.getString("surname","no existe") ?: "no existe", // Forma mas elegante de tratar el posible null
            sharedPref.getBoolean("is_active", true)
        )
    }
}