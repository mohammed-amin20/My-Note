package com.mohamed.mynote.feature_note.presentation.view_notes

import com.mohamed.mynote.feature_note.domain.model.Note
import com.mohamed.mynote.feature_note.domain.util.NoteOrder
import com.mohamed.mynote.feature_note.domain.util.OrderType

data class NotesState(
    val notes : List<Note> = emptyList(),
    val noteOrder : NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible : Boolean = false
)
