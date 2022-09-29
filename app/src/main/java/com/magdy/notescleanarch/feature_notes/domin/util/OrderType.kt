package com.magdy.notescleanarch.feature_notes.domin.util

sealed class OrderType{
    object Ascending:OrderType()
    object Descending:OrderType()
}
