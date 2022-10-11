package com.dherranz1.aad.ut01.ex05.data

import com.dherranz1.aad.ut01.ex05.data.local.OpenedLocalDataSource
import com.dherranz1.aad.ut01.ex05.data.local.UsersLocalDataSource

class CounterRepository(val localSource: OpenedLocalDataSource) {


    fun updateCounter(): Int = localSource.updateCounter()
    fun getCounter(): Int = localSource.getCounter()
    fun removeCounter() = localSource.removeCounter()


}