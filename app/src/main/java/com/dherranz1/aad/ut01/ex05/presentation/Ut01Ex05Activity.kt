package com.dherranz1.aad.ut01.ex05.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.dherranz1.aad.R
import com.dherranz1.aad.ut01.ex05.data.UserRepository
import com.dherranz1.aad.ut01.ex05.data.local.UsersLocalDataSource
import com.dherranz1.aad.ut01.ex05.data.remote.UsersRemoteDataSource

class Ut01Ex05Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut01_ex05)


    }
/*
    private fun init(){
        //Obtain all users from data layer
        val userRepository = UserRepository(
            UsersLocalDataSource(),
            UsersRemoteDataSource()
        )

        val users = userRepository.getUsers()
        Log.d("@dev", "Users: $users")

    }

 */
}