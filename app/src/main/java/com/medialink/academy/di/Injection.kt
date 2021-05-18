package com.medialink.academy.di

import android.content.Context
import com.medialink.academy.data.source.AcademyRepository
import com.medialink.academy.data.source.remote.RemoteDataSource
import com.medialink.academy.utils.JsonHelper

object Injection {

    fun provideRepository(context: Context): AcademyRepository {
        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        return AcademyRepository.getInstance(remoteDataSource)
    }
}