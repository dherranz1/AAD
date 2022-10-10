package com.dherranz1.aad.ut01.ex05.data.remote

import android.util.Log
import com.dherranz1.aad.ut01.ex05.data.remote.models.UserApiModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class UsersRemoteDataSource {

    var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var service: UserApiService = retrofit.create(UserApiService::class.java)

    /**
     * Mock
     * Replace with getUser from PSP
     */
    fun getUsers() : List<UserApiModel>{

        Log.d("@dev", "Obteniendo usuarios REMOTO")

        val callUsers = service.getUsers()
        val response = callUsers.execute()

        return if (response.isSuccessful)
            response.body()?: emptyList()
        else
            emptyList<UserApiModel>()

    }

    fun getUserById(userId : Int ) : UserApiModel?{

        Log.d("@dev", "Buscando usuario REMOTO")

        val callUsers = service.getUserById(userId)
        val response = callUsers.execute()

        return if (response.isSuccessful)
            response.body()?: null
        else
            null

    }
}