package com.dherranz1.aad.ut01.ex05.data.local

import android.content.SharedPreferences
import android.util.Log
import com.dherranz1.aad.ut01.ex05.domain.User
import com.google.gson.Gson

class UsersLocalDataSource(private val sharedPreferences: SharedPreferences) {


    private val editor: SharedPreferences.Editor = sharedPreferences.edit()
    private val gson = Gson()

    fun saveUsers(users: List<User>) =
        editor.apply {
            users.forEach { usuario ->
                val json = gson.toJson(usuario)

                putString(usuario.id.toString(), json)
            }
            Log.d("@dev","Guardando usuarios LOCAL")
        }.apply()


    fun getUsers(): List<User> {

        Log.d("@dev","Obteniendo usuarios LOCAL")

        var userList = mutableListOf<User>()

        sharedPreferences.all.forEach { user ->
            val usuario = gson.fromJson(user.value as String, User::class.java)
            userList.add(usuario)
        }

        return userList
    }

    fun getUserById(userId: Int): User? =
        sharedPreferences.getString(userId.toString(), null)?.let { json ->
            gson.fromJson(json, User::class.java)
        }

    fun removeUser(userId: Int) =
        editor.remove(userId.toString()).apply()


}