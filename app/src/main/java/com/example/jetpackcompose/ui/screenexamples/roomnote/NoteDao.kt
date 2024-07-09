package com.example.jetpackcompose.ui.screenexamples.roomnote

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Query("SELECT * FROM note_entities")
    fun getAllNotes(): Flow<List<NoteEntity>>

    @Insert
    suspend fun insertNoteEntity(noteEntity: NoteEntity)

    @Upsert
    suspend fun upsertNote(noteEntity: NoteEntity)

    /*  @Query("SELECT * FROM note_table WHERE id = :id")
      suspend fun getById(id: Int): NoteEntity
  */
    @Update
    suspend fun updateNote(noteEntity: NoteEntity)

    @Delete
    suspend fun deleteNote(noteEntity: NoteEntity)
}