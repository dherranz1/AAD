package com.dherranz1.aad.ut01.ex01.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dherranz1.aad.R
import com.dherranz1.aad.ut01.ex01.data.SharedPreferenceLocalSource
import com.dherranz1.aad.ut01.ex01.domain.Customer

class Ut01Ex01Activity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut01ex01)

        initSharedPreferences()
    }

    private fun initSharedPreferences(){
        //val spCustomer: SharedPreferenceLocalSource = SharedPreferenceLocalSource(this)
        val spCustomer = SharedPreferenceLocalSource(this)
        spCustomer.saveCustomer(Customer(1,"Customer1","Surname1", true))
    }
}