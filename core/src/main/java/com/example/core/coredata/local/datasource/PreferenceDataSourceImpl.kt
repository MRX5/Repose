package com.example.core.coredata.local.datasource

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import com.example.core.coredata.datasource.PreferenceDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PreferenceDataSourceImpl @Inject constructor(
    private val dataStore: DataStore<Preferences>
):PreferenceDataSource{
    override suspend fun getValue(key: String, default: Any?): Flow<Any?> =
        dataStore.data.map{
            when(default){
                is String -> {
                    it[stringPreferencesKey(key)]?:default
                }
                is Double -> {
                    it[doublePreferencesKey(key)]?:default
                }
                is Int -> {
                    it[intPreferencesKey(key)] ?: default
                }
                is Float -> {
                    it[floatPreferencesKey(key)] ?: default
                }
                is Boolean -> {
                    it[booleanPreferencesKey(key)] ?: default
                }

                is Long -> {
                    it[longPreferencesKey(key)] ?: default
                }
                else -> default
            }
        }

    override suspend fun setValue(key: String, value: Any?) {
        dataStore.edit {
            when(value){
                is String -> {
                    it[stringPreferencesKey(key)] = value
                }

                is Double -> {
                    it[doublePreferencesKey(key)] = value
                }

                is Int -> {
                    it[intPreferencesKey(key)] = value
                }

                is Float -> {
                    it[floatPreferencesKey(key)] = value
                }

                is Boolean -> {
                    it[booleanPreferencesKey(key)] = value
                }

                is Long -> {
                    it[longPreferencesKey(key)] = value
                }
            }
        }
    }

}