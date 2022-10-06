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
    fun getUsers(){
        var users = localSource.getUsers()
        if(users == null){
            users = remoteDataSource.getUsers()
            localSource.saveUsers(users)
        }
    }
/*
    fun getUserById(userId : Int) : User {
        // TODO : verificar en local, si no, en remoto
    }
*/
    fun removeUser(userId : Int){}
}