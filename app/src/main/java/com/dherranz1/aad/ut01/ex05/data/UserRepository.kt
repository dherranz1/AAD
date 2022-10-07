package com.dherranz1.aad.ut01.ex05.data

import com.dherranz1.aad.ut01.ex05.data.local.UsersLocalDataSource
import com.dherranz1.aad.ut01.ex05.data.remote.UsersRemoteDataSource
import com.dherranz1.aad.ut01.ex05.domain.User

class UserRepository (val localSource: UsersLocalDataSource,
                      val remoteDataSource: UsersRemoteDataSource
                      ){

    /**
     *  First from local and then from remote
     */

    fun getUsers() : List <User>{

        var users = localSource.getUsers()

        if(users.isEmpty())
            users = remoteDataSource.getUsers()

        return users
    }

    fun saveUsers(userList : List<User>) =
        localSource.saveUsers(userList)


    fun getUserById(userId : Int) : User? =
        localSource.getUserById(userId)?: remoteDataSource.getUserById(userId)


    fun removeUser(userId : Int) = localSource.removeUser(userId)


}