package com.example.jetpackcompose.ui.screenExamples.room

import androidx.lifecycle.LiveData
import javax.inject.Inject

class TextRepository @Inject constructor(private val dao: TextEntryDao) {
    val allEntries: LiveData<List<TextEntry>> = dao.getAllEntries()

    suspend fun insert(entry: TextEntry) {
        dao.insert(entry)
    }
}

/*
class TextRepository(private val dao: TextEntryDao) {
    val allEntries: LiveData<List<TextEntry>> = dao.getAllEntries()

    suspend fun insert(entry: TextEntry) {
        dao.insert(entry)
    }
}
*/
