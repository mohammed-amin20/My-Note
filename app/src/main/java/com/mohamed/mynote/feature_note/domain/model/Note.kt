package com.mohamed.mynote.feature_note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mohamed.mynote.ui.theme.BabyBlue
import com.mohamed.mynote.ui.theme.LightGreen
import com.mohamed.mynote.ui.theme.RedOrange
import com.mohamed.mynote.ui.theme.RedPink
import com.mohamed.mynote.ui.theme.Violet

@Entity
data class Note(
    val title : String,
    val content : String,
    val timestamp : Long,
    val color : Int,
    @PrimaryKey val id : Int? = null
) {
    companion object{
        val noteColors = listOf(RedOrange , LightGreen, BabyBlue , Violet , RedPink)
    }
}

class InvalidNoteException(message : String) : Exception(message)