package com.dherranz1.aad.ut01.ex01.data

import android.app.Activity
import android.content.Context
import com.dherranz1.aad.ut01.ex01.domain.Customer

// El fichero xml generado unicamente puede ser accedido por la actividad que se le pasa

class PreferenceLocalSourceI(private val activity: Activity) : PreferenceSource(activity) {

    override var sharedPref = activity.getPreferences(Context.MODE_PRIVATE)

}