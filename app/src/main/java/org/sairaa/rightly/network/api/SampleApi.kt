package org.sairaa.rightly.network.api

import org.sairaa.rightly.database.model.Sample
import retrofit2.Response
import retrofit2.http.GET

interface SampleApi {

    @GET("/test")
    suspend fun getAllSample():Response<List<Sample>>

}