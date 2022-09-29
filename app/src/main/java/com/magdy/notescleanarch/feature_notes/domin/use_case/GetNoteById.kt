package com.magdy.notescleanarch.feature_notes.domin.use_case

import com.magdy.notescleanarch.feature_notes.domin.model.Note
import com.magdy.notescleanarch.feature_notes.domin.repository.NoteRepository

class GetNoteById(
    private val noteRepository: NoteRepository
) {
    suspend operator fun invoke(id:Int): Note?{
        return noteRepository.getNoteById(id)
    }
}