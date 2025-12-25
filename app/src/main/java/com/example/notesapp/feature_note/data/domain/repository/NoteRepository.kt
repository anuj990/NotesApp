package com.example.notesapp.feature_note.data.domain.repository

import com.example.notesapp.feature_note.data.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    fun getNote(): Flow<List<Note>>


    suspend fun getNoteBYID(id:Int): Note?

    suspend fun insertNote(note: Note)

    suspend fun deleteNote(note: Note)


}