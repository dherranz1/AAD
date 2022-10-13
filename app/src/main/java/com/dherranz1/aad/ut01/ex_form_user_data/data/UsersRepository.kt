package com.dherranz1.aad.ut01.ex_form_user_data.data

import com.dherranz1.aad.ut01.ex_form_user_data.data.apimodels.UserApiModel
import com.dherranz1.aad.ut01.ex_form_user_data.data.local.UsersLocalDataSource
import com.dherranz1.aad.ut01.ex_form_user_data.data.remote.UsersRemoteDataSource


class UsersRepository (val localSource: UsersLocalDataSource,
                       val remoteDataSource: UsersRemoteDataSource
){


    fun create(user: UserApiModel) =
        localSource.create(user)

    fun delete(userId : Int) =
        localSource.delete(userId)


    // Busca un usuario en local, si no existe, se carga de remoto y se guarda en local
    fun read(userId : Int) : UserApiModel?{
        var user = localSource.read(userId)

        if (user == null)
            remoteDataSource.read(userId)?.let { user ->
                localSource.create(user)
            }

        return user
    }


    fun update(user : UserApiModel) =
        localSource.update(user)

}