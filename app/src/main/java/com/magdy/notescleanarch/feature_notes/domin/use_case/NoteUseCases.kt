package com.magdy.notescleanarch.feature_notes.domin.use_case

data class NoteUseCases(
   val getNotes:GetNotes,
   val deleteNote: DeleteNote,
   val addNote: AddNote,
   val getNoteById:GetNoteById
)