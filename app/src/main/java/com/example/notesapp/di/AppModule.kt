package com.example.notesapp.di

import android.app.Application
import androidx.room.Room
import com.example.notesapp.feature_note.data.data_source.NoteDataBase
import com.example.notesapp.feature_note.data.domain.repository.NoteRepository
import com.example.notesapp.feature_note.data.domain.use_case.AddNotes
import com.example.notesapp.feature_note.data.domain.use_case.DeleteNote
import com.example.notesapp.feature_note.data.domain.use_case.GetNote
import com.example.notesapp.feature_note.data.domain.use_case.GetNotesUseCase
import com.example.notesapp.feature_note.data.domain.use_case.NoteUseCases
import com.example.notesapp.feature_note.data.repository.NoteRepositoryImpl
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
    fun provideNoteDatabase(app: Application): NoteDataBase {
        return Room.databaseBuilder(
            app,
            NoteDataBase::class.java,
            NoteDataBase.DATABASE_NAME
        ).build()

    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDataBase): NoteRepository {
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNotesUseCase = GetNotesUseCase(repository),
            deleteNote = DeleteNote(repository),
            addNote = AddNotes(repository),
            getNote = GetNote(repository)
        )
    }
}
