package com.mohamed.mynote.feature_note.presentation.view_notes

import com.mohamed.mynote.feature_note.domain.model.Note
import com.mohamed.mynote.feature_note.domain.util.NoteOrder

sealed interface NotesEvent {
    data class Order ( val noteOrder: NoteOrder) : NotesEvent
    data class DeleteNote(val note: Note) : NotesEvent
    data object RestoreNote: NotesEvent
    data object ToggleOrderSection: NotesEvent
}