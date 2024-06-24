package com.example.jetpackcompose.ui.screenExamples.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface TextEntryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entry: TextEntry)

    @Query("SELECT * FROM text_entries")
    fun getAllEntries(): LiveData<List<TextEntry>>
}
