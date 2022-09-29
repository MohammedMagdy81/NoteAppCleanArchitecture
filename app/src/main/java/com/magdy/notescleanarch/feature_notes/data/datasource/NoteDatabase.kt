package com.magdy.notescleanarch.feature_notes.data.datasource

import androidx.room.Database
import androidx.room.RoomDatabase
import com.magdy.notescleanarch.feature_notes.domin.model.Note

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NoteDatabase :RoomDatabase(){

    abstract val noteDao:NoteDao

    companion object{
        const val DATABASE_NAME="notes_db"
    }
}
