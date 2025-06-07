package com.example.templateapp.data.repository

import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject

class UserPreferenceRepository @Inject constructor (
    private val dataStore: DataStore<Preferences>
) {
    private companion object {
        private const val TAG = "UserPreferenceRepository"
        val IS_DARK_MODE = booleanPreferencesKey("is_dark_mode")
        val ORDERED_BY_AREA = booleanPreferencesKey("ordered_by_area")
    }

    val isDarkMode: Flow<Boolean> = dataStore.data
        .catch {
            if(it is IOException) {
                Log.e(TAG, "Error reading preferences.", it)
                emit(emptyPreferences())
            } else {
                throw it
            }
        }
        .map { preferences ->
        preferences[IS_DARK_MODE] ?: false
    }

    val isOrderedByArea: Flow<Boolean> = dataStore.data
        .catch {
            if(it is IOException) {
                Log.e(TAG, "Error reading preferences.", it)
                emit(emptyPreferences())
            } else {
                throw it
            }
        }
        .map { preferences ->
        preferences[ORDERED_BY_AREA] ?: false
    }

    suspend fun saveDarkModePreference(isDarkMode: Boolean) {
        dataStore.edit { preferences ->
            preferences[IS_DARK_MODE] = isDarkMode
        }
    }

    suspend fun saveListOrderPreference(ordererdByArea: Boolean) {
        dataStore.edit { preferences ->
            preferences[ORDERED_BY_AREA] = ordererdByArea
        }
    }
}