package com.dherranz1.aad.ut01.ex05.presentation

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.dherranz1.aad.R
import com.dherranz1.aad.ut01.ex05.data.UserRepository
import com.dherranz1.aad.ut01.ex05.data.local.UsersLocalDataSource
import com.dherranz1.aad.ut01.ex05.data.remote.UsersRemoteDataSource
import com.dherranz1.aad.ut01.ex05.domain.User

class Ut01Ex05Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut01_ex05)

        init()
    }

    private fun init(){

        Log.d("@dev","Actividad 5")

        //Obtain all users from data layer

        val sharedPreferences = this.getSharedPreferences(
            this.getString(R.string.sharedpreferences_ut01ex05),
            Context.MODE_PRIVATE
        )

        val userRepository = UserRepository(
            UsersLocalDataSource(sharedPreferences),
            UsersRemoteDataSource()
        )

        // Partiendo de un sharedPreferences inexistente
        Thread{

            val user = userRepository.getUserById(2)

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
            userList.forEach{ user: User ->
                Log.d("@dev","Usuario: $user")
            }

            // Guardando en local los usuarios
            userRepository.saveUsers(userList)

            Log.d("@dev","=====================")

            // Recuperando los usuarios
            userRepository.getUsers().forEach{ user : User ->
                Log.d("@dev", "Usuario: $user")
            }

            Log.d("@dev","=====================")
            Log.d("@dev","Eliminando usuario 3")
            Log.d("@dev","=====================")
            userRepository.removeUser(3)

            // Recuperando los usuarios para verificar que se ha eliminado el usuario
            userRepository.getUsers().forEach{ user : User ->
                Log.d("@dev", "Usuario: $user")
            }

        }.start()
/*
        val listaUsuarios = mutableListOf<User>(
            User(1,"User1","UserName1"),
            User(2,"User2","UserName2"),
            User(3,"User3","UserName3"),
            User(4,"User4","UserName4")
        )

 */

    }


}