package com.example.dqn.network.api

import com.example.dqn.database.model.Sample
import retrofit2.Response
import retrofit2.http.GET

interface SampleApi {

    @GET("/test")
    suspend fun getAllSample():Response<List<Sample>>

}