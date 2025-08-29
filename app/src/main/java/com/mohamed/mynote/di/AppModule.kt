package com.mohamed.mynote.di

import android.app.Application
import androidx.room.Room
import com.mohamed.mynote.feature_note.data.data_source.NoteDatabase
import com.mohamed.mynote.feature_note.data.repository.NoteRepositoryImpl
import com.mohamed.mynote.feature_note.domain.repository.NoteRepository
import com.mohamed.mynote.feature_note.domain.use_case.AddNote
import com.mohamed.mynote.feature_note.domain.use_case.DeleteNote
import com.mohamed.mynote.feature_note.domain.use_case.GetNotes
import com.mohamed.mynote.feature_note.domain.use_case.NotesUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesNoteDatabase(app : Application): NoteDatabase{

        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun providesNoteRepository(db : NoteDatabase) : NoteRepository{
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun providesNoteUseCases(repository: NoteRepository) : NotesUseCases{
        return NotesUseCases(
            getNotes = GetNotes(repository),
            deleteNote = DeleteNote(repository),
            addNote = AddNote(repository)
        )
    }
}