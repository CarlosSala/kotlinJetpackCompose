package com.example.jetpackcompose.ui.screenExamples.settings

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

// name groups of preferences
private val Context.dataStore by preferencesDataStore(name = "welcome_prefs")

private val WELCOME_SHOWN_KEY = booleanPreferencesKey("welcome_shown")

// save values on DataStore
suspend fun setWelcomeShown(context: Context) {
    context.dataStore.edit { preferences ->
        preferences[WELCOME_SHOWN_KEY] = true
    }
}

fun getWelcomeShown(context: Context): Flow<Boolean> {

    return context.dataStore.data
        .catch { exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }
        .map { preferences ->
            preferences[WELCOME_SHOWN_KEY] ?: false
        }
}
