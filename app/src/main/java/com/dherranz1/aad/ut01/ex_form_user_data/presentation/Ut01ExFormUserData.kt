package com.dherranz1.aad.ut01.ex_form_user_data.presentation

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.dherranz1.aad.R
import com.dherranz1.aad.ut01.ex_form_user_data.data.UsersRepository
import com.dherranz1.aad.ut01.ex_form_user_data.data.apimodels.AddressUserApiModel
import com.dherranz1.aad.ut01.ex_form_user_data.data.apimodels.CompanyUserApiModel
import com.dherranz1.aad.ut01.ex_form_user_data.data.apimodels.GeolocationUserApiModel
import com.dherranz1.aad.ut01.ex_form_user_data.data.apimodels.UserApiModel
import com.dherranz1.aad.ut01.ex_form_user_data.data.local.UsersLocalDataSource


class Ut01ExFormUserData : AppCompatActivity() {

    val sharedPreferencesName = "usersSharedPreferences"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut01_ex_form_user_data)

        val usersLocalDataSource = UsersLocalDataSource(this.getSharedPreferences(sharedPreferencesName, Context.MODE_PRIVATE))
        val usersRepository = UsersRepository(usersLocalDataSource)

        // Probando funcion CREATE
        usersRepository.create(UserApiModel(
            1,
            "Pedro",
            "userPedro",
            "pedro@gmail.com",
            AddressUserApiModel(
                "Calle Ejemplo",
                "apt. 556",
                "Avila",
                "05240",
                GeolocationUserApiModel(
                    "-37.2344",
                    "81.3454"
                )
            ),
            "920123421",
            "direccionweb.com",
            CompanyUserApiModel(
                "Nueva compañia",
                "Ejemplo Ejemplo",
                "harness real-time"
            )
        ))

        usersRepository.create(UserApiModel(
            2,
            "Jose",
            "userJose",
            "jose@gmail.com",
            AddressUserApiModel(
                "Calle Ejemplo",
                "apt. 556",
                "Avila",
                "05240",
                GeolocationUserApiModel(
                    "-37.2344",
                    "81.3454"
                )
            ),
            "920123421",
            "direccionweb.com",
            CompanyUserApiModel(
                "Nueva compañia",
                "Ejemplo Ejemplo",
                "harness real-time"
            )
        ))

        Log.d("@dev", "Probando funcion de guardado")

        // Probando funcion DELETE
        Thread{
            Thread.sleep(3000)
            usersRepository.delete(1)
            Log.d("@dev", "Usuario eliminado")
        }.start()


        val user = usersRepository.read(2)
        Log.d("@dev", "Leyendo usuario con id ${user?.id}: $user")

        user?.let {

            Log.d("@dev", "Actualizando usuario con id ${user?.id}: $user")

            val updatedUser = UserApiModel(
                2,
                "JoseModificado",
                "userJoseModificado",
                "jose@gmail.com",
                AddressUserApiModel(
                    "Calle Ejemplo",
                    "apt. 556",
                    "Avila",
                    "05240",
                    GeolocationUserApiModel(
                        "-37.2344",
                        "81.3454"
                    )
                ),
                "920123421",
                "direccionweb.com",
                CompanyUserApiModel(
                    "Nueva compañia",
                    "Ejemplo Ejemplo",
                    "harness real-time"
                )
            )

            usersRepository.update(updatedUser)

            Log.d("@dev", "Nueva informacion de usuario con id ${user?.id}: " + usersRepository.read(user.id).toString())
        }

    }
}