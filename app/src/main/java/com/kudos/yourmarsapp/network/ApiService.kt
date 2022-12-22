package com.kudos.yourmarsapp.network

import com.kudos.yourmarsapp.network.models.AmphibiansApiResponse
import com.kudos.yourmarsapp.network.models.MarsApiResponse
import retrofit2.http.GET

interface ApiService {

    @GET("https://android-kotlin-fun-mars-server.appspot.com/photos")
    suspend fun getMarsPhotos(): MarsApiResponse

    @GET("https://developer.android.com/courses/pathways/android-basics-kotlin-unit-4-pathway-2/android-basics-kotlin-unit-4-pathway-2-project-api.json")
    suspend fun getAmphibians(): AmphibiansApiResponse
}