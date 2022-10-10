package com.dherranz1.aad.ut01.ex05.data.local

import android.content.SharedPreferences
import android.util.Log
import com.dherranz1.aad.ut01.ex05.data.remote.models.UserApiModel
import com.google.gson.Gson

class UsersLocalDataSource(private val sharedPreferences: SharedPreferences) {


    private val editor: SharedPreferences.Editor = sharedPreferences.edit()
    private val gson = Gson()


    fun saveUsers(users : List<UserApiModel>){
        users.forEach{
            saveUser(it)
        }
    }


    private fun saveUser(user : UserApiModel){
        val json = gson.toJson(user, UserApiModel::class.java)
        editor.putString(user.id.toString(), json)
        editor.apply()
    }

    fun getUsers(): List<UserApiModel> {

        Log.d("@dev","Obteniendo usuarios LOCAL")

        var userList = mutableListOf<UserApiModel>()

        sharedPreferences.all.forEach { user ->
            val usuario = gson.fromJson(user.value as String, UserApiModel::class.java)
            userList.add(usuario)
        }

        return userList
    }

    fun getUserById(userId: Int): UserApiModel? =
        sharedPreferences.getString(userId.toString(), null)?.let { json ->
            gson.fromJson(json, UserApiModel::class.java)
        }


    fun removeUser(userId: Int) =
        editor.remove(userId.toString()).apply()


}