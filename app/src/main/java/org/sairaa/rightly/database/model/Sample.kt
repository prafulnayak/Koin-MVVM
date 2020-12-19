package org.sairaa.rightly.database.model

import android.provider.BaseColumns
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sample")
data class Sample(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = BaseColumns._ID) val id: Long,
    @ColumnInfo(name = "heading") val heading: String? = null,
    @ColumnInfo(name = "description") val description: String? = null
)