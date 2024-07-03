package com.example.jetpackcompose.ui.screenexamples.room

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch


class NoteViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: NoteRepository

    val allTextEntries: Flow<List<NoteEntity>>

    init {
        val noteEntityDao = NoteDatabase.getDatabase(application).noteDao
        repository = NoteRepository(noteEntityDao)
        allTextEntries = repository.allTextEntries
    }

    fun insert(text: String) {
        viewModelScope.launch {
            repository.insert(text)
        }
    }
}

/*
class NoteViewModel(private val noteRepository: NoteRepository) : ViewModel() {

    fun getNotes() = noteRepository.getAllNotes().asLiveData(viewModelScope.coroutineContext)

    fun upsertNote(note: NoteEntity) {
        viewModelScope.launch {
            noteRepository.upsertNote(note)
        }
    }

    fun deleteNote(note: NoteEntity) {
        viewModelScope.launch {
            noteRepository.deleteNote(note)
        }
    }
}*/
