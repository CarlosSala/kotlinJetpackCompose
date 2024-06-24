package com.example.jetpackcompose.ui.screenExamples.room

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TextViewModel @Inject constructor(
    application: Application,
    private val repository: TextRepository
) : AndroidViewModel(application) {

    val allEntries: LiveData<List<TextEntry>> = repository.allEntries

    fun insert(entry: TextEntry) = viewModelScope.launch {
        repository.insert(entry)
    }
}



/*class TextViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: TextRepository

    val allEntries: LiveData<List<TextEntry>>

    init {
        val dao = AppDatabase.getDatabase(application).textEntryDao()
        repository = TextRepository(dao)
        allEntries = repository.allEntries
    }

    fun insert(entry: TextEntry) = viewModelScope.launch {
        repository.insert(entry)
    }
}*/
