package com.example.jetpackcompose.ui.screenexamples.room


import kotlinx.coroutines.flow.Flow

class NoteRepository(private val noteDao: NoteDao) {

    val allTextEntries: Flow<List<NoteEntity>> = noteDao.getAllNotes()

    suspend fun insert(text: String) {
        noteDao.insertNoteEntity(NoteEntity(text, "custom_body"))
    }
}


/*

class NoteRepository(private val db: NoteDatabase) {

    suspend fun upsertNote(note: NoteEntity) {
        db.noteDao.upsertNote(note)
    }

    suspend fun deleteNote(note: NoteEntity) {
        db.noteDao.deleteNote(note)
    }

    fun getAllNotes() = db.noteDao.getAllNotes()
}*/
