package com.magdy.notescleanarch.feature_notes.domin.use_case

import com.magdy.notescleanarch.feature_notes.domin.model.Note
import com.magdy.notescleanarch.feature_notes.domin.repository.NoteRepository
import com.magdy.notescleanarch.feature_notes.domin.util.NoteOrder
import com.magdy.notescleanarch.feature_notes.domin.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetNotes(
    private val noteRepository: NoteRepository
) {

    operator fun invoke(
        noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending)// this how to sort noteslist
    ): Flow<List<Note>> {
        return noteRepository.getAllNotes().map { notes ->
            when (noteOrder.orderType) {

                is OrderType.Ascending -> {
                    when (noteOrder) {
                        is NoteOrder.Title -> notes.sortedBy { it.title.lowercase() }
                        is NoteOrder.Date -> notes.sortedBy { it.timeStamp }
                        is NoteOrder.Color -> notes.sortedBy { it.color }
                    }
                }


                is OrderType.Descending -> {
                    when (noteOrder) {
                        is NoteOrder.Title -> notes.sortedByDescending { it.title }
                        is NoteOrder.Date -> notes.sortedByDescending { it.timeStamp }
                        is NoteOrder.Color -> notes.sortedByDescending { it.color }
                    }
                }

            }
        }
    }


}
