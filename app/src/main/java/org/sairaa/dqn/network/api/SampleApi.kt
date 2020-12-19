package org.sairaa.dqn.network.api

import org.sairaa.dqn.database.model.Sample
import retrofit2.Response
import retrofit2.http.GET

interface SampleApi {

    @GET("/test")
    suspend fun getAllSample():Response<List<Sample>>

}