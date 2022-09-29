package com.magdy.notescleanarch.feature_notes.domin.use_case

import com.magdy.notescleanarch.feature_notes.domin.model.Note
import com.magdy.notescleanarch.feature_notes.domin.repository.NoteRepository

class DeleteNote(
    private val noteRepository: NoteRepository
) {
     suspend operator fun invoke(note:Note){
        noteRepository.deleteNote(note)
    }
}