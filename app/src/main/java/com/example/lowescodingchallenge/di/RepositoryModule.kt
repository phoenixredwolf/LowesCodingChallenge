package com.example.lowescodingchallenge.di

import com.example.lowescodingchallenge.data.repo.DataRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    // DI call for repository
    fun providesDataRepository() = DataRepository()

}