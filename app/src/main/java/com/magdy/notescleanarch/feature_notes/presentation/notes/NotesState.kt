package com.magdy.notescleanarch.feature_notes.presentation.notes

import com.magdy.notescleanarch.feature_notes.domin.model.Note
import com.magdy.notescleanarch.feature_notes.domin.util.NoteOrder
import com.magdy.notescleanarch.feature_notes.domin.util.OrderType

data class NotesState(

    val notes:List<Note> = emptyList(),
    val noteOrder:NoteOrder=NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible:Boolean=false

)
