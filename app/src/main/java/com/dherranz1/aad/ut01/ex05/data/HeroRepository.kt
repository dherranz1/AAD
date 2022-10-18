package com.dherranz1.aad.ut01.ex05.data

import com.dherranz1.aad.ut01.ex05.data.remote.HeroesRemoteDataSource
import com.dherranz1.aad.ut01.ex05.data.remote.models.SuperHero
import com.dherranz1.aad.ut01.ex05.data.remote.models.UserApiModel

class HeroRepository (val remoteDataSource: HeroesRemoteDataSource){

    fun getHeroById(heroId : Int) : SuperHero? =
        remoteDataSource.getHeroById(heroId)

    fun getHeroes() : List <SuperHero> = remoteDataSource.getHeroes()

}