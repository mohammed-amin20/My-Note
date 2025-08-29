package com.mohamed.mynote.feature_note.data.data_source

import androidx.room.Database
import com.mohamed.mynote.feature_note.data.data_source.NoteDatabase.Companion.DATABASE_VERSION
import com.mohamed.mynote.feature_note.domain.model.Note

@Database(
    entities = [Note::class],
    version = DATABASE_VERSION
)
abstract class NoteDatabase {

    abstract val noteDao : NoteDao

    companion object{
        const val DATABASE_NAME = "Note"
        const  val DATABASE_VERSION = 1
    }
}