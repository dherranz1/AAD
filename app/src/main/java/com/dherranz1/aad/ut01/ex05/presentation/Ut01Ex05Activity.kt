package com.dherranz1.aad.ut01.ex05.presentation

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.dherranz1.aad.R
import com.dherranz1.aad.ut01.ex05.data.HeroRepository
import com.dherranz1.aad.ut01.ex05.data.UserRepository
import com.dherranz1.aad.ut01.ex05.data.local.UsersLocalDataSource
import com.dherranz1.aad.ut01.ex05.data.remote.HeroesRemoteDataSource
import com.dherranz1.aad.ut01.ex05.data.remote.UsersRemoteDataSource


class Ut01Ex05Activity : AppCompatActivity() {

    var openedTimes = 0
    private val MAX_TIMES = 5
    private val USE_COUNTER_MESSAGE = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_ut01_ex05)
        setContentView(R.layout.layout_contador_usos)

        init()

    }

    private fun init(){

        // Sharedpreferences for users
        val sharedPreferences = this.getSharedPreferences(
            this.getString(R.string.sharedpreferences_ut01ex05),
            Context.MODE_PRIVATE
        )

        val userRepository = UserRepository(
            UsersLocalDataSource(sharedPreferences),
            UsersRemoteDataSource()
        )

        val heroRepository = HeroRepository(HeroesRemoteDataSource())

        // Partiendo de un sharedPreferences inexistente
        Thread{

            val hero = heroRepository.getHeroById(1)
            val heroes = heroRepository.getHeroes()

            Log.d("@dev","Hero : $hero")

            heroes.forEach { hero ->
                Log.d("@dev", "Heroe lista : $hero")
            }

            /*
            val user = userRepository.getUserById(1)

            // Peticion de un unico usuario (Peticion a remoto por no haber local)
            if(user!=null)
                Log.d("@dev","Usuario: $user")
            else
                Log.d("@dev","Usuario no encontrado")


            // Peticion de todos los usuarios (Peticion a remoto por no haber local)
            Log.d("@dev","=====================")
            Log.d("@dev","= Lista de usuarios =")
            Log.d("@dev","=====================")

            var userList = userRepository.getUsers()
            userList.forEach{ user ->
                Log.d("@dev","Usuario: $user")
            }

            // Guardando en local los usuarios
            //userRepository.saveUsers(userList)

            // Autoguardado en local los usuarios al usar getUsers
            Log.d("@dev","=====================")

            // Recuperando los usuarios
            userRepository.getUsers().forEach{ user  ->
                Log.d("@dev", "Usuario: $user")
            }

            Log.d("@dev","=====================")
            Log.d("@dev","Eliminando usuario 3")
            Log.d("@dev","=====================")
            userRepository.removeUser(3)

            // Recuperando los usuarios para verificar que se ha eliminado el usuario
            userRepository.getUsers().forEach{ user ->
                Log.d("@dev", "Usuario: $user")
            }
            */
        }.start()


    }


}




/*



         */