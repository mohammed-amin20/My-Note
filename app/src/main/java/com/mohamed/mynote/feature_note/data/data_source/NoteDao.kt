package com.mohamed.mynote.feature_note.data.data_source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.mohamed.mynote.feature_note.domain.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Query("SELECT * FROM note")
    fun getNotes(): Flow<List<Note>>

    @Query("SELECT * FROM note WHERE Id = :id")
    suspend fun getNoteById(id : Int): Note?

    @Upsert
    suspend fun upsertNote(note: Note )

    @Delete
    suspend fun deleteNote(note: Note)
}