package com.dherranz1.aad.ut01.ex_form_user_data.data.local

import android.content.SharedPreferences
import android.util.Log
import com.dherranz1.aad.ut01.ex_form_user_data.data.apimodels.UserApiModel
import com.google.gson.Gson

class UsersLocalDataSource(private val sharedPreferences: SharedPreferences) {


    private val editor: SharedPreferences.Editor = sharedPreferences.edit()
    private val gson = Gson()


    fun readAll() : List<UserApiModel>{
        val userList = mutableListOf<UserApiModel>()
        val map = sharedPreferences.all

        map.forEach {
            userList.add(gson.fromJson(it.value.toString(), UserApiModel::class.java))
        }

        return userList
    }


    fun saveAll(listaUsuarios : List<UserApiModel>){
        listaUsuarios.forEach{ user ->
            create(user)
        }
    }

    fun create(user: UserApiModel){
        val json = gson.toJson(user, UserApiModel::class.java)
        editor.putString(user.id.toString(), json)
        editor.apply()
    }

    fun delete(userId : Int) =
        editor.remove(userId.toString()).apply()

    fun read(userId : Int) : UserApiModel? = sharedPreferences.getString(userId.toString(), null)?.let { json ->
        gson.fromJson(json, UserApiModel::class.java)
    }

    fun update(user : UserApiModel)=
        create(user)

}