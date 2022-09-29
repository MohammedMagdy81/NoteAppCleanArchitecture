package com.magdy.notescleanarch.di

import android.app.Application
import androidx.room.Room
import com.magdy.notescleanarch.feature_notes.data.datasource.NoteDatabase
import com.magdy.notescleanarch.feature_notes.data.repository.NoteRepositoryImpl
import com.magdy.notescleanarch.feature_notes.domin.repository.NoteRepository
import com.magdy.notescleanarch.feature_notes.domin.use_case.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideNotesDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        )
            .build()
    }

    @Singleton
    @Provides
    fun provideNotesRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(db.noteDao)
    }

    @Singleton
    @Provides
    fun provideNoteUseCases(noteRepository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNotes = GetNotes(noteRepository),
            deleteNote = DeleteNote(noteRepository),
            addNote = AddNote(noteRepository),
            getNoteById = GetNoteById(noteRepository)
        )
    }
}

















