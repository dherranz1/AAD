package com.dherranz1.aad.ut01.ex05.data.remote

import com.dherranz1.aad.ut01.ex05.domain.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Path


interface UserApiService {

    @GET("users/")
    fun getUsers() : Call<List<User>>

    @GET("users/{id}")
    fun getUserById(@Path("id") id : Int) : Call<User>

}