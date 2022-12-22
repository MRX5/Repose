package com.example.domain.prayer_times.repository

import com.example.core.coredomain.utils.Resource
import com.example.domain.prayer_times.model.PrayerTimeModel
import kotlinx.coroutines.flow.Flow

interface PrayerTimesRepository {
    suspend fun getPrayerTimes(): Flow<Resource<PrayerTimeModel>>
}