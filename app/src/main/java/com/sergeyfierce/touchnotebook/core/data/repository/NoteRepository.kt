package com.sergeyfierce.touchnotebook.core.data.repository

import com.sergeyfierce.touchnotebook.core.data.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    fun getNotes(contactId: Long): Flow<List<Note>>
    suspend fun add(note: Note)
}

class InMemoryNoteRepository @javax.inject.Inject constructor() : NoteRepository {
    private val data = mutableListOf<Note>()
    override fun getNotes(contactId: Long): Flow<List<Note>> =
        kotlinx.coroutines.flow.flow { emit(data.filter { it.contactId == contactId }) }

    override suspend fun add(note: Note) {
        data += note
    }
}
