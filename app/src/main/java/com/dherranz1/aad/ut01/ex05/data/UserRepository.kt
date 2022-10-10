package com.dherranz1.aad.ut01.ex05.data

import com.dherranz1.aad.ut01.ex05.data.local.UsersLocalDataSource
import com.dherranz1.aad.ut01.ex05.data.remote.UsersRemoteDataSource
import com.dherranz1.aad.ut01.ex05.data.remote.models.UserApiModel

class UserRepository (val localSource: UsersLocalDataSource,
                      val remoteDataSource: UsersRemoteDataSource
                      ){

    /**
     *  First from local and then from remote
     */

    fun getUsers() : List <UserApiModel>{

        var users = localSource.getUsers()

        if(users.isEmpty())
            users = remoteDataSource.getUsers()

        // Guardar usuarios con el save

        return users
    }

    fun saveUsers(userList : List<UserApiModel>) =
        localSource.saveUsers(userList)


    fun getUserById(userId : Int) : UserApiModel? =
        localSource.getUserById(userId)?: remoteDataSource.getUserById(userId)


    fun removeUser(userId : Int) = localSource.removeUser(userId)


}