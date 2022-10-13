package com.dherranz1.aad.ut01.ex_form_user_data.data

import android.util.Log
import com.dherranz1.aad.ut01.ex_form_user_data.data.apimodels.UserApiModel
import com.dherranz1.aad.ut01.ex_form_user_data.data.local.UsersLocalDataSource
import com.dherranz1.aad.ut01.ex_form_user_data.data.remote.UsersRemoteDataSource


class UsersRepository (val localSource: UsersLocalDataSource,
                       val remoteDataSource: UsersRemoteDataSource
){


    fun create(user: UserApiModel){

        //TODO contemplar introduccion sin id. Verificar que no existe ya guardado.

        localSource.create(user)
    }


    fun delete(userId : Int) =
        localSource.delete(userId)


    // Busca un usuario en local, si no existe, se carga de remoto y se guarda en local
    fun read(userId : Int) : UserApiModel?{
        var user = localSource.read(userId)

        if (user == null)
            remoteDataSource.read(userId)?.let { user ->
                user?.let { localSource.create(user) }
            }

        return user
    }

    fun readAll() : List<UserApiModel> {
        var userList = localSource.readAll()

        if(userList.isEmpty()) {
            userList = remoteDataSource.readAll()
            localSource.saveAll(userList)
        }

        return userList
    }


    fun update(user : UserApiModel) =
        localSource.update(user)

}