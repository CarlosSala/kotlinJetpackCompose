package com.example.jetpackcompose.ui.screenexamples.roomnote


import kotlinx.coroutines.flow.Flow

class NoteRepository(private val noteDao: NoteDao) {

    val allTextEntries: Flow<List<NoteEntity>> = noteDao.getAllNotes()

    suspend fun insert(text: String) {
        noteDao.insertNoteEntity(NoteEntity(text, "custom_body"))
    }

    suspend fun upsertNote(note: NoteEntity) {
        noteDao.upsertNote(note)
    }

    suspend fun deleteNote(note: NoteEntity) {
        noteDao.deleteNote(note)
    }

    fun getAllNotes() = noteDao.getAllNotes()
}
