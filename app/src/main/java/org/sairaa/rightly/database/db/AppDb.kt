package org.sairaa.rightly.database.db

import androidx.room.Database
import androidx.room.RoomDatabase
import org.sairaa.rightly.database.dao.SampleDao
import org.sairaa.rightly.database.model.Sample

@Database(entities = [Sample::class],version = 1, exportSchema = false)
abstract class AppDb:RoomDatabase(){
    abstract val  sampleDao: SampleDao
}