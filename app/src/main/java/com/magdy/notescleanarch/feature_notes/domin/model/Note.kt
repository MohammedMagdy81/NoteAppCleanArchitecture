package com.magdy.notescleanarch.feature_notes.domin.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.magdy.notescleanarch.ui.theme.*

@Entity
data class Note(
    val title:String,
    val content:String,
    val timeStamp:Long,
    val color:Int,
    @PrimaryKey val id :Int?= null
){
    companion object{
        var myColors= listOf(redOrange, babyBlue, redPink, lightGreen,violet)
    }

}

class InvalidNoteException(message:String):Exception(message)
