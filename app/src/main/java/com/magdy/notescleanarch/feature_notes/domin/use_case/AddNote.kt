package com.magdy.notescleanarch.feature_notes.domin.use_case

import com.magdy.notescleanarch.feature_notes.domin.model.InvalidNoteException
import com.magdy.notescleanarch.feature_notes.domin.model.Note
import com.magdy.notescleanarch.feature_notes.domin.repository.NoteRepository

class AddNote(
    private val noteRepository: NoteRepository
) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note:Note){

        if (note.title.isBlank() ||note.content.isBlank()){
            throw InvalidNoteException("Please Enter All Note Data !")
        }

        noteRepository.insertNote(note)
    }
}