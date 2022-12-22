package com.example.core.coredata.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import com.example.core.coredata.datasource.PreferenceDataSource
import com.example.core.coredata.local.datasource.PreferenceDataSourceImpl
import com.example.core.coredata.local.repository.PreferenceRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PreferenceModule {
    private const val PREF_NAME = "repose_pref"

    @Provides
    @Singleton
    fun providePreferenceDataStore(@ApplicationContext context: Context): DataStore<Preferences> =
        PreferenceDataStoreFactory.create(
            produceFile = {
                context.preferencesDataStoreFile(PREF_NAME)
            }
        )

    @Provides
    @Singleton
    fun providePreferencesDataSource(dataStore: DataStore<Preferences>)=PreferenceDataSourceImpl(dataStore)

    @Provides
    @Singleton
    fun providePreferencesRepository(preferencesDataSource: PreferenceDataSource)=
        PreferenceRepositoryImpl(preferencesDataSource)
}