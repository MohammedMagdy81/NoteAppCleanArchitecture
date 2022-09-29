package com.magdy.notescleanarch.feature_notes.presentation.utils

sealed class NoteScreens(val route:String) {
    object NotesScreen:NoteScreens("notes_screen")
    object AddEditNoteScreen:NoteScreens("add_edit_note_screen")
}