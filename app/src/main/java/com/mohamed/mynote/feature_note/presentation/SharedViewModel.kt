package com.mohamed.mynote.feature_note.presentation

import androidx.lifecycle.ViewModel
import com.mohamed.mynote.feature_note.domain.model.Note

class SharedViewModel: ViewModel() {
    var note : Note? = null
}