package com.example.dqn.database.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.dqn.database.dao.SampleDao
import com.example.dqn.database.model.Sample

@Database(entities = [Sample::class],version = 1, exportSchema = false)
abstract class AppDb:RoomDatabase(){
    abstract val  sampleDao:SampleDao
}