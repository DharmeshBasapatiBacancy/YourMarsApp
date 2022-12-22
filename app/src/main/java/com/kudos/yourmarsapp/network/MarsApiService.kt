package com.kudos.yourmarsapp.network

import com.kudos.yourmarsapp.network.models.MarsApiResponse
import retrofit2.http.GET

interface MarsApiService {

    @GET("photos")
    suspend fun getMarsPhotos(): MarsApiResponse
}