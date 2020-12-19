package org.sairaa.rightly.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import org.sairaa.rightly.database.model.Sample

@Dao
interface SampleDao{

    @Query("SELECT * FROM sample")
    fun getSampleDao():List<Sample>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(sample: List<Sample>)
}