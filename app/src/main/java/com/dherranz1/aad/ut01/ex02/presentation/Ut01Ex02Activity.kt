package com.dherranz1.aad.ut01.ex02.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.dherranz1.aad.R
import com.dherranz1.aad.ut01.ex01.data.*

class Ut01Ex02Activity : AppCompatActivity() {

    var firstOpened = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut01ex02)

        val sharedPreference = SharedPreferenceLocalSource(this)

        if (!sharedPreference.getFirstOpened()){
            sharedPreference.saveFirstOpened()
            firstOpened = true

            Log.d("@dev", "Primera apertura")
        }
        else{
            Log.d("@dev", "No es la primera apertura")
        }
    }
}