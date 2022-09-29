package com.magdy.notescleanarch.feature_notes.data.repository

import com.magdy.notescleanarch.feature_notes.data.datasource.NoteDao
import com.magdy.notescleanarch.feature_notes.domin.model.Note
import com.magdy.notescleanarch.feature_notes.domin.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(private val noteDao: NoteDao) : NoteRepository {

    override fun getAllNotes(): Flow<List<Note>> {
        return noteDao.getAllNotes()
    }

    override suspend fun insertNote(note: Note) {
        noteDao.insertNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        noteDao.deleteNote(note)
    }

    override suspend fun getNoteById(id: Int): Note? {
        return noteDao.getNoteById(id)
    }
}