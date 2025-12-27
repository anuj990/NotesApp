package com.example.notesapp.feature_note.data.domain.use_case

import com.example.notesapp.feature_note.data.domain.model.Note
import com.example.notesapp.feature_note.data.domain.repository.NoteRepository

class GetNote(private val repository: NoteRepository) {
    suspend operator fun invoke(id: Int): Note? {
        return repository.getNoteBYID(id)

    }
}