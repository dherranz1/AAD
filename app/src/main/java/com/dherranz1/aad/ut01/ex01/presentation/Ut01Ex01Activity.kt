package com.dherranz1.aad.ut01.ex01.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.dherranz1.aad.R
import com.dherranz1.aad.ut01.ex01.data.PreferenceLocalSourceI
import com.dherranz1.aad.ut01.ex01.data.IPreferencesSource
import com.dherranz1.aad.ut01.ex01.data.SharedPreferenceLocalSource
import com.dherranz1.aad.ut01.ex01.domain.Customer

class Ut01Ex01Activity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut01ex01)

        //initSharedPreferences()
        //initPreferences()
    }

    private fun initXmlPreferences(IPreferencesSource: IPreferencesSource) {

        IPreferencesSource.saveCustomer(Customer(3, "Customer3", "Surname3", true))

        val newCustomer = IPreferencesSource.getCustomer()
        Log.d("@dev", "Customer $newCustomer")
    }

    private fun initSharedPreferences(){
        //val spCustomer: SharedPreferenceLocalSource = SharedPreferenceLocalSource(this)
        val spCustomer = SharedPreferenceLocalSource(this)
        initXmlPreferences(spCustomer)
    }

    private fun initPreferences(){
        val spCustomer = PreferenceLocalSourceI(this)
        initXmlPreferences(spCustomer)
    }
}