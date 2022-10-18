package com.dherranz1.aad.ut01.ex05.data.remote

import android.util.Log
import com.dherranz1.aad.ut01.ex05.data.remote.models.SuperHero
import com.dherranz1.aad.ut01.ex05.data.remote.models.UserApiModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class HeroesRemoteDataSource {

    var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var service: HeroesApiService = retrofit.create(HeroesApiService::class.java)


    fun getHeroes() : List<SuperHero>{

        Log.d("@dev", "Obteniendo usuarios REMOTO")

        val callUsers = service.getUsers()
        val response = callUsers.execute()

        return if (response.isSuccessful)
            response.body()?: emptyList()
        else
            emptyList<SuperHero>()

    }


    fun getHeroById(userId : Int ) : SuperHero?{

        Log.d("@dev", "Buscando Heroe REMOTO")

        val callUsers = service.getHeroById(userId)
        val response = callUsers.execute()

        return if (response.isSuccessful)
            response.body()?: null
        else
            null

    }
}