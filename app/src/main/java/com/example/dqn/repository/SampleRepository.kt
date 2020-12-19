package com.example.dqn.repository

import android.content.Context
import com.example.dqn.database.dao.SampleDao
import com.example.dqn.database.model.Sample
import com.example.dqn.network.api.SampleApi
import java.lang.Exception

interface SampleRepository{
    suspend fun getAllSampleData():List<Sample>
}

class SampleRepositoryImpl(private val api:SampleApi,private val context:Context, private val sampleDao: SampleDao):SampleRepository{
    override suspend fun getAllSampleData(): List<Sample> {
        try {
            val response = api.getAllSample()
        }catch (e:Exception){

        }

        return arrayListOf(Sample(1,"test","test Description"))
    }
}

