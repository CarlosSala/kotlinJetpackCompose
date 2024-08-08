package com.example.jetpackcompose.ui.screenexamples.roomnote2.di

import android.content.Context
import androidx.room.Room
import com.example.jetpackcompose.ui.screenexamples.roomnote2.data.DefaultRepository
import com.example.jetpackcompose.ui.screenexamples.roomnote2.data.TaskRepository
import com.example.jetpackcompose.ui.screenexamples.roomnote2.data.source.local.TaskDao
import com.example.jetpackcompose.ui.screenexamples.roomnote2.data.source.local.TaskDatabase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindTaskRepository(repository: DefaultRepository): TaskRepository
}

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDataBase(@ApplicationContext context: Context): TaskDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            TaskDatabase::class.java,
            "Tasks.db"
        ).build()
    }

    @Provides
    fun provideTaskDao(database: TaskDatabase): TaskDao = database.getTaskDao()
}