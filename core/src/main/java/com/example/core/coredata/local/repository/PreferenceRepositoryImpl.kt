package com.example.core.coredata.local.repository

import com.example.core.coredata.datasource.PreferenceDataSource
import com.example.core.coredomain.repository.PreferenceRepository
import com.example.core.utils.PreferenceConstants
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PreferenceRepositoryImpl @Inject constructor(
    private val preferencesDataSource: PreferenceDataSource
) : PreferenceRepository {
    override suspend fun setIsFirstTime(value: Boolean) =
        preferencesDataSource.setValue(PreferenceConstants.IS_FIRST_TIME, value)


    override suspend fun getIsFirstTime(): Flow<Boolean> = flow {
        preferencesDataSource.getValue(PreferenceConstants.IS_FIRST_TIME, false).collect{
            emit(it as Boolean)
        }
    }



}