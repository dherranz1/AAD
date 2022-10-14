package com.dherranz1.aad.ut01.ex_form_user_data.data.remote


import com.dherranz1.aad.ut01.ex_form_user_data.data.apimodels.UserApiModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface UserApiService {

    @GET("users/")
    fun readAll() : Call<List<UserApiModel>>

    @GET("users/{id}")
    fun read(@Path("id") id : Int) : Call<UserApiModel>

}