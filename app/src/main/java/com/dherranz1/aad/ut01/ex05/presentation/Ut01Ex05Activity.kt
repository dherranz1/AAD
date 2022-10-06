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
        //Obtain all users from data layer

        val sharedPreferences = this.getSharedPreferences(
            this.getString(R.string.sharedpreferences_ut01ex05),
            Context.MODE_PRIVATE
        )

        val listaUsuarios = mutableListOf<User>(
            User(1,"User1","UserName1"),
            User(2,"User2","UserName2"),
            User(3,"User3","UserName3"),
            User(4,"User4","UserName4")
        )

        val userRepository = UserRepository(
            UsersLocalDataSource(sharedPreferences),
            UsersRemoteDataSource()
        )

        userRepository.saveUsers(listaUsuarios)

        Log.d("@dev","Actividad 5")

        /*
        val users = userRepository.getUsers()

         */
        //Log.d("@dev", "Users: $users")

    }


}