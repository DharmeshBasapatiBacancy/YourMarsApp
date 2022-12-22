package com.kudos.yourmarsapp.di

import com.kudos.yourmarsapp.network.MarsApiService
import com.kudos.yourmarsapp.repository.MarsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideMarsRepository(marsApiService: MarsApiService): MarsRepository {
        return MarsRepository(marsApiService)
    }

}