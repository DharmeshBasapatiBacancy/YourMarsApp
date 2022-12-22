package com.kudos.yourmarsapp.repository

import com.kudos.yourmarsapp.network.ApiService
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getMarsPhotos() = apiService.getMarsPhotos()

    suspend fun getAmphibians() = apiService.getAmphibians()

}