package org.sairaa.rightly.repository

import android.content.Context
import org.sairaa.rightly.database.dao.SampleDao
import org.sairaa.rightly.database.model.Sample
import org.sairaa.rightly.network.api.SampleApi
import java.lang.Exception

interface SampleRepository{
    suspend fun getAllSampleData():List<Sample>
}

class SampleRepositoryImpl(private val api: SampleApi, private val context:Context, private val sampleDao: SampleDao):
    SampleRepository {
    override suspend fun getAllSampleData(): List<Sample> {
        try {
            val response = api.getAllSample()
        }catch (e:Exception){

        }

        return arrayListOf(
            Sample(
                1,
                "test",
                "test Description"
            )
        )
    }
}

