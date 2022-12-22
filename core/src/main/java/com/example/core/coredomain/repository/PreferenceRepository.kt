package com.example.core.coredomain.repository

import kotlinx.coroutines.flow.Flow

interface PreferenceRepository {
    suspend fun setIsFirstTime(value: Boolean)
    suspend fun getIsFirstTime(): Flow<Boolean>
}