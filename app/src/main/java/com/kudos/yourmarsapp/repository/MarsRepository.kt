package com.kudos.yourmarsapp.repository

import com.kudos.yourmarsapp.network.MarsApiService
import com.kudos.yourmarsapp.network.models.MarsApiResponse
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MarsRepository @Inject constructor(private val marsApiService: MarsApiService) {

    suspend fun getMarsPhotos() = marsApiService.getMarsPhotos()

}