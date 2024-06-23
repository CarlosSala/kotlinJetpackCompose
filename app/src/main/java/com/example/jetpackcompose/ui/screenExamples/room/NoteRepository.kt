package com.example.jetpackcompose.ui.screenExamples.room

class NoteRepository(private val db: NoteDatabase) {

    suspend fun upsertNote(note: NoteEntity) {
        db.noteDao.upsertNote(note)
    }

    suspend fun deleteNote(note: NoteEntity) {
        db.noteDao.deleteNote(note)
    }

    fun getAllNotes() = db.noteDao.getAllNotes()
}