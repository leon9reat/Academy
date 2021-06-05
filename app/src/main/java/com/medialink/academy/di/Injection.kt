package com.medialink.academy.di

import android.content.Context
import com.medialink.academy.data.source.AcademyRepository
import com.medialink.academy.data.source.local.LocalDataSource
import com.medialink.academy.data.source.local.room.AcademyDatabase
import com.medialink.academy.data.source.remote.RemoteDataSource
import com.medialink.academy.utils.AppExecutors
import com.medialink.academy.utils.JsonHelper

object Injection {

    fun provideRepository(context: Context): AcademyRepository {

        val database = AcademyDatabase.getInstance(context)
        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        val localDataSource = LocalDataSource.getInstance(database.academyDao())
        val appExecutors = AppExecutors()

        return AcademyRepository.getInstance(
            remoteDataSource,
            localDataSource,
            appExecutors
        )
    }
}