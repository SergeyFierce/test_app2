package com.sergeyfierce.touchnotebook.di

import com.sergeyfierce.touchnotebook.core.data.repository.ContactRepository
import com.sergeyfierce.touchnotebook.core.data.repository.InMemoryContactRepository
import com.sergeyfierce.touchnotebook.core.data.repository.InMemoryNoteRepository
import com.sergeyfierce.touchnotebook.core.data.repository.NoteRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {
    @Binds
    @Singleton
    abstract fun bindContactRepository(repo: InMemoryContactRepository): ContactRepository

    @Binds
    @Singleton
    abstract fun bindNoteRepository(repo: InMemoryNoteRepository): NoteRepository
}
