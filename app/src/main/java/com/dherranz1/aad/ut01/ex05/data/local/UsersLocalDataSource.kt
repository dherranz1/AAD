package com.dherranz1.aad.ut01.ex05.data.local

import android.app.Activity
import android.content.Context
import androidx.core.content.ContextCompat
import com.dherranz1.aad.R
import com.dherranz1.aad.ut01.ex05.domain.User
import com.dherranz1.aad.ut01.ex05.presentation.Ut01Ex05Activity
import com.google.gson.Gson

class UsersLocalDataSource(activity: Activity) {

    val sharedPreferences = activity.getSharedPreferences(activity.getString(R.string.sharedpreferences_ut01ex05), Context.MODE_PRIVATE)

    val editor = sharedPreferences.edit()
    val gson = Gson()

    fun saveUsers(users: List<User>) {

        users.forEach { usuario ->
            val json = gson.toJson(usuario)
            editor.putString(usuario.id.toString(), json)
        }
        editor.apply()
    }

    fun getUsers(): List<User>? {

        var userList : MutableList<User> = emptyList<User>() as MutableList<User>

        sharedPreferences.all.forEach{ user ->
            val usuario = gson.fromJson(user.value as String, User::class.java)
            userList.add(usuario)
        }

        return userList
    }

    fun findById(userId: Int): User? =
        sharedPreferences.getString(userId.toString(), null)?.let { json ->
            gson.fromJson(json, User::class.java)
        }

    fun remove(userId: Int) {
        var listaUsuarios = mutableListOf<User>()
        listaUsuarios = getUsers() as MutableList<User>

        if (listaUsuarios == null){

        }

    }
}