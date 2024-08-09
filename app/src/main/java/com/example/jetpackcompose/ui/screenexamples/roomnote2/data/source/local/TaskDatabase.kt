package com.example.jetpackcompose.ui.screenexamples.roomnote2.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [TaskEntity::class],
    version = 1,
    exportSchema = false
)
abstract class TaskDatabase : RoomDatabase() {

    abstract fun getTaskDao(): TaskDao

    /*
        companion object {

          @Volatile
            private var INSTANCE: TaskDatabase? = null

            fun getDatabase(context: Context): TaskDatabase {
                return INSTANCE ?: synchronized(this) {
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                        TaskDatabase::class.java,
                        "task_database"
                    ).build()
                    INSTANCE = instance
                    instance
                }
            }
        }   */
}