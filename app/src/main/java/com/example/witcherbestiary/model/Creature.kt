package com.example.witcherbestiary.model

import android.os.Parcelable
import androidx.compose.runtime.Immutable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(
    tableName = "creatures",
    indices = [
        Index("name", unique = true)
    ]
)
@Immutable
data class Creature(
    @PrimaryKey @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "preview_url") val previewUrl: String,
    @ColumnInfo(name = "image_url") val imgUrl: String,
    @ColumnInfo(name = "description") val description: String
) : Parcelable