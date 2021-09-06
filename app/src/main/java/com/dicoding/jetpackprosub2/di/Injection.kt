package com.dicoding.jetpackprosub2.di

import android.content.Context
import com.dicoding.jetpackprosub2.data.source.DataRepository
import com.dicoding.jetpackprosub2.data.source.remote.RemoteDataSource

object Injection {
    fun provideRepository(context: Context): DataRepository {
        val remDataSource = RemoteDataSource.getInstance()
        return DataRepository.getInstance(remDataSource)
    }
}