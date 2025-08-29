package com.mohamed.mynote.feature_note.presentation.add_edit_note

import androidx.lifecycle.ViewModel
import com.mohamed.mynote.feature_note.domain.use_case.NotesUseCases
import javax.inject.Inject

data class NoteTextFieldState(
    val text: String = "",
    val hint: String = "",
    val isHintVisible: Boolean = true
)