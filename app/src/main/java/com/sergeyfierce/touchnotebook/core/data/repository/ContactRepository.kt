package com.sergeyfierce.touchnotebook.core.data.repository

import com.sergeyfierce.touchnotebook.core.data.model.Category
import com.sergeyfierce.touchnotebook.core.data.model.Contact
import kotlinx.coroutines.flow.Flow

interface ContactRepository {
    fun getContacts(category: Category): Flow<List<Contact>>
    suspend fun add(contact: Contact)
}

class InMemoryContactRepository @javax.inject.Inject constructor() : ContactRepository {
    private val data = mutableListOf<Contact>()
    override fun getContacts(category: Category): Flow<List<Contact>> =
        kotlinx.coroutines.flow.flow { emit(data.filter { it.category == category }) }

    override suspend fun add(contact: Contact) {
        data += contact
    }
}
