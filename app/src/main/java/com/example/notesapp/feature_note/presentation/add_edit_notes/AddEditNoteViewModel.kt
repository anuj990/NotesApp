package com.example.notesapp.feature_note.presentation.add_edit_notes

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.notesapp.feature_note.data.domain.use_case.NoteUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.compose.runtime.State

@HiltViewModel
class AddEditNoteViewModel @Inject constructor(
    private val noteUseCases: NoteUseCases
) : ViewModel() {
    private val _noteTitle = mutableStateOf("")
    val noteTitle: State<String> = _noteTitle


}