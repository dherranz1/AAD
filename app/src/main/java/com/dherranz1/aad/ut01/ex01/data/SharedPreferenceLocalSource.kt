package com.dherranz1.aad.ut01.ex01.data

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.dherranz1.aad.R
import com.dherranz1.aad.ut01.ex01.domain.Customer

// El fichero xml generado puede ser accedido por cualquier parte de la aplicacion

class SharedPreferenceLocalSource(val activity: AppCompatActivity) : PreferenceSource(activity) {

    override var sharedPref = activity.getSharedPreferences(activity.getString(R.string.preference_ut01ex01), Context.MODE_PRIVATE)

}