package com.example.jetpackcompose.ui.screenexamples.roomnote

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch


class NoteViewModel(application: Application) : AndroidViewModel(application) {

    private val noteRepository: NoteRepository

    val allTextEntries: Flow<List<NoteEntity>>

    init {
        val noteEntityDao = NoteDatabase.getDatabase(application).noteDao
        noteRepository = NoteRepository(noteEntityDao)
        allTextEntries = noteRepository.allTextEntries
    }

    fun insert(text: String) {
        viewModelScope.launch {
            noteRepository.insert(text)
        }
    }


/*    fun upsertNote(note: NoteEntity) {
        viewModelScope.launch {
            noteRepository.upsertNote(note)
        }
    }

    fun deleteNote(note: NoteEntity) {
        viewModelScope.launch {
            noteRepository.deleteNote(note)
        }
    }*/
}
