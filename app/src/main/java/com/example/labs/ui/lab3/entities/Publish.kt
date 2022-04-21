package com.example.labs.ui.lab3.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Publish(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "type") val type: PublishType,
    @ColumnInfo(name = "index") val index: Int,
    @ColumnInfo(name = "price") val price: Int
)