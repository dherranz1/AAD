package com.dherranz1.aad.ut01.ex05.data.remote

import com.dherranz1.aad.ut01.ex05.data.remote.models.SuperHero
import com.dherranz1.aad.ut01.ex05.data.remote.models.UserApiModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface HeroesApiService {

    @GET("api/all.json")
    fun getUsers() : Call<List<SuperHero>>

    @GET("api/id/{id}.json")
    fun getHeroById(@Path("id") id : Int) : Call<SuperHero>

}