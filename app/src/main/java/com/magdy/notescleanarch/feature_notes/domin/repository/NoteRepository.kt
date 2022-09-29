package com.magdy.notescleanarch.feature_notes.domin.repository

import com.magdy.notescleanarch.feature_notes.domin.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    fun getAllNotes():Flow<List<Note>>

    suspend fun insertNote(note: Note)

    suspend fun deleteNote(note: Note)

    suspend fun getNoteById(id:Int):Note?

}