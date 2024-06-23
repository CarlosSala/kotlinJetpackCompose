package com.example.jetpackcompose.ui.screenExamples.room

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


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
}