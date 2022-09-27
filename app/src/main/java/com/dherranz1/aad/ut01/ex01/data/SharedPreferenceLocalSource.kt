package com.dherranz1.aad.ut01.ex01.data

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.dherranz1.aad.R
import com.dherranz1.aad.ut01.ex01.domain.Customer

// El fichero xml generado puede ser accedido por cualquier parte de la aplicacion

class SharedPreferenceLocalSource(val activity: AppCompatActivity) {

    val sharedPref = activity.getSharedPreferences(activity.getString(R.string.preference_ut01ex01), Context.MODE_PRIVATE)

    fun saveCustomer(customer: Customer){

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

    fun getCustomer() : Customer{

        return Customer(
            sharedPref.getInt("id",0),
            sharedPref.getString("name","no existe")!!, // Ignorar si es nulo asumiendo riesgos
            sharedPref.getString("surname","no existe") ?: "no existe", // Forma mas elegante de tratar el posible null
            sharedPref.getBoolean("is_active", true)
        )
    }

}