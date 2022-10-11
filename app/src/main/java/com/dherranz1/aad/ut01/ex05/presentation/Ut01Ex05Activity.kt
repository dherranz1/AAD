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
import com.dherranz1.aad.ut01.ex05.data.UserRepository
import com.dherranz1.aad.ut01.ex05.data.local.OpenedLocalDataSource
import com.dherranz1.aad.ut01.ex05.data.local.UsersLocalDataSource
import com.dherranz1.aad.ut01.ex05.data.remote.UsersRemoteDataSource

class Ut01Ex05Activity : AppCompatActivity() {

    var openedTimes = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_ut01_ex05)
        setContentView(R.layout.layout_contador_usos)

        init()



    }

    private fun init(){

        Log.d("@dev","Actividad 5")

        // Sharedpreferences for users
        val sharedPreferences = this.getSharedPreferences(
            this.getString(R.string.sharedpreferences_ut01ex05),
            Context.MODE_PRIVATE
        )

        val userRepository = UserRepository(
            UsersLocalDataSource(sharedPreferences),
            UsersRemoteDataSource()
        )


        // Apartado contador de usos
        initResetButton()

        openedTimes = getCounterRepository().updateCounter()

        if(openedTimes == 5)
            Log.d("@dev", "Usado ya 5 veces")

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




/*
        // Partiendo de un sharedPreferences inexistente
        Thread{

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
            userRepository.saveUsers(userList)

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

        }.start()


         */