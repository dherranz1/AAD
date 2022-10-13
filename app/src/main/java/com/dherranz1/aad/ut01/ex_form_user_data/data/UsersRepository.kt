package com.dherranz1.aad.ut01.ex_form_user_data.data

import com.dherranz1.aad.ut01.ex_form_user_data.data.apimodels.UserApiModel
import com.dherranz1.aad.ut01.ex_form_user_data.data.local.UsersLocalDataSource


class UsersRepository (val localSource: UsersLocalDataSource/*,
                       val remoteDataSource: UsersRemoteDataSource*/){


    fun create(user: UserApiModel) =
        localSource.create(user)

    fun delete(userId : Int) =
        localSource.delete(userId)

    fun read(userId : Int) : UserApiModel? =
        localSource.read(userId)


    fun update(user : UserApiModel) =
        localSource.update(user)

}