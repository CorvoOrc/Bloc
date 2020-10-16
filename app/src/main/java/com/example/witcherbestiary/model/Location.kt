package com.example.witcherbestiary.model

import android.os.Parcelable
import androidx.compose.runtime.Immutable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(
    tableName = "locations"
)
@Immutable
data class Location(
    @PrimaryKey @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "x") val x: Float,
    @ColumnInfo(name = "y") val y: Float
) : Parcelable