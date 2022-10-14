package com.dherranz1.aad.ut01.ex_form_user_data.presentation

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.dherranz1.aad.R
import com.dherranz1.aad.ut01.ex_form_user_data.data.UsersRepository
import com.dherranz1.aad.ut01.ex_form_user_data.data.apimodels.AddressUserApiModel
import com.dherranz1.aad.ut01.ex_form_user_data.data.apimodels.CompanyUserApiModel
import com.dherranz1.aad.ut01.ex_form_user_data.data.apimodels.GeolocationUserApiModel
import com.dherranz1.aad.ut01.ex_form_user_data.data.apimodels.UserApiModel
import com.dherranz1.aad.ut01.ex_form_user_data.data.local.UsersLocalDataSource
import com.dherranz1.aad.ut01.ex_form_user_data.data.remote.UsersRemoteDataSource


class Ut01ExFormUserData : AppCompatActivity() {

    private val sharedPreferencesName = "formSharedPreferences"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut01_ex_form_user_data)

        val usersLocalDataSource = UsersLocalDataSource(this.getSharedPreferences(sharedPreferencesName, Context.MODE_PRIVATE))
        val usersRemoteDataSource = UsersRemoteDataSource()
        val usersRepository = UsersRepository(usersLocalDataSource,usersRemoteDataSource)

        Thread{

            val id = 5

            Log.d("@dev","Listando todos los usuarios")
            Log.d("@dev","===========================")
            usersRepository.readAll().forEach {
                Log.d("@dev","Usuario : $it")
            }
            Log.d("@dev","")


            Log.d("@dev","Buscando el usuario usuario $id")
            Log.d("@dev","=============================")

            val usuario = usersRepository.read(id)?.let {

                Log.d("@dev","Usuario $id : $it")
                it.copy()
            }
            Log.d("@dev","")


            Log.d("@dev","Actualizando el nombre del usuario $id")
            usuario?.let {
                it.name = "MODIFICADO"
                usersRepository.update(usuario)
            }
            Log.d("@dev","")

            Log.d("@dev","Usuario $id actualizado")
            usersRepository.read(id)?.let {

                Log.d("@dev","Usuario $id : $it")
                it.copy()
            }
            Log.d("@dev","")


            Log.d("@dev","Borrando el usuario usuario $id")
            usersRepository.delete(id)
            Log.d("@dev","")


            Log.d("@dev","Listando todos los usuarios")
            Log.d("@dev","===========================")
            usersRepository.readAll().forEach {
                Log.d("@dev","Usuario : $it")
            }
            Log.d("@dev","")


        }.start()

    }

}