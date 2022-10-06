package com.dherranz1.aad.ut01.ex05.data.local

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.core.content.ContextCompat
import com.dherranz1.aad.R
import com.dherranz1.aad.ut01.ex05.domain.User
import com.dherranz1.aad.ut01.ex05.presentation.Ut01Ex05Activity
import com.google.gson.Gson

class UsersLocalDataSource(sharedPreferences: SharedPreferences) {


    val sharedPreferences = sharedPreferences
    val editor = sharedPreferences.edit()
    val gson = Gson()

    /*
        fun saveUsers(users: List<User>) {

            users.forEach { usuario ->
                val json = gson.toJson(usuario)
                editor.putString(usuario.id.toString(), json)
            }
            editor.apply()
        }
    */
    fun saveUsers(users: List<User>) =
        editor.apply {
            users.forEach { usuario ->
                val json = gson.toJson(usuario)
                Log.d("@dev","$json")
                editor.putString(usuario.id.toString(), json)
                editor.
            }
            Log.d("@dev","Guardar usuarios")
        }

/*
    fun getUsers(): List<User>? {

        var userList: MutableList<User> = mutableListOf<User>()

        sharedPreferences.all.forEach { user ->
            val usuario = gson.fromJson(user.value as String, User::class.java)
            userList.add(usuario)
        }

        return userList
    }
*/
    fun findById(userId: Int): User? =
        sharedPreferences.getString(userId.toString(), null)?.let { json ->
            gson.fromJson(json, User::class.java)
        }

    fun remove(userId: Int) =
        sharedPreferences.all.remove(userId.toString())

}