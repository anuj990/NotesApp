package com.example.notesapp.feature_note.data.domain.use_case

import com.example.notesapp.feature_note.data.domain.model.Note
import com.example.notesapp.feature_note.data.domain.repository.NoteRepository

class DeleteNote(private val repository: NoteRepository) {


    suspend operator fun invoke(note: Note){
        return repository.deleteNote(note)
    }
}