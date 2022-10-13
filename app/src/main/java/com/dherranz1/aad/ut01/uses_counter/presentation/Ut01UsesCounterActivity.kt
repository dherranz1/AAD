package com.dherranz1.aad.ut01.ex05.presentation

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.dherranz1.aad.R
import com.dherranz1.aad.ut01.ex05.data.CounterRepository
import com.dherranz1.aad.ut01.ex05.data.local.OpenedLocalDataSource
import com.google.android.material.snackbar.Snackbar

class Ut01UsesCounterActivity : AppCompatActivity() {

    var openedTimes = 0
    private val MAX_TIMES = 5
    private val USE_COUNTER_MESSAGE = "Ha abierto la app $MAX_TIMES veces"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_ut01_ex05)
        setContentView(R.layout.layout_contador_usos)

        init()
    }

    private fun init(){

        initResetButton()

        openedTimes = getCounterRepository().updateCounter()

        if(openedTimes == MAX_TIMES) {
            Log.d("@dev", "Usado ya 5 veces")
            Snackbar.make(findViewById(R.id.main_layout), USE_COUNTER_MESSAGE, Snackbar.LENGTH_LONG).show()
        }

        updateCounterTextView(openedTimes)

    }


    fun updateCounterTextView(counter : Int)=
        findViewById<TextView>(R.id.uses_counter).setText("Número de usos: " + counter.toString())


    private fun getCounterSharedPreferences() : SharedPreferences =
        this.getSharedPreferences(
            this.getString(R.string.sharedpreferences_counter),
            Context.MODE_PRIVATE
        )

    private fun getCounterRepository() : CounterRepository = CounterRepository(OpenedLocalDataSource(getCounterSharedPreferences()))


    private fun initResetButton(){
        val resetButton = findViewById<Button>(R.id.reset_button)

        resetButton.setOnClickListener {
            getCounterRepository().removeCounter()
            updateCounterTextView(getCounterRepository().getCounter())
        }
    }

}



