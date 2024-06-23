package com.example.jetpackcompose.ui.screenExamples.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Upsert
    suspend fun upsertNote(noteEntity: NoteEntity)

    @Query("SELECT * FROM noteentity")
    fun getAllNotes(): Flow<List<NoteEntity>>

  /*  @Query("SELECT * FROM note_table WHERE id = :id")
    suspend fun getById(id: Int): NoteEntity
*/
    @Update
    suspend fun updateNote(noteEntity: NoteEntity)

    @Delete
    suspend fun deleteNote(noteEntity: NoteEntity)
}