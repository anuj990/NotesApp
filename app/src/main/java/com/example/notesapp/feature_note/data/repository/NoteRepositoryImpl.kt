package com.example.notesapp.feature_note.data.repository

import com.example.notesapp.feature_note.data.data_source.NoteDao
import com.example.notesapp.feature_note.data.domain.model.Note
import com.example.notesapp.feature_note.data.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(private val dao: NoteDao) : NoteRepository {

    override fun getNote(): Flow<List<Note>> {
        return dao.getNote()
    }

    override suspend fun getNoteBYID(id: Int): Note? {
        return dao.getNoteById(id)
    }

    override suspend fun insertNote(note: Note) {
        return dao.insertNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        return dao.deleteNote(note)
    }
}