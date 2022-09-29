package com.dherranz1.aad.ut01.ex01.data

import com.dherranz1.aad.ut01.ex01.domain.Customer

interface IPreferencesSource {
    fun saveCustomer(customer: Customer)
    fun getCustomer() : Customer

}