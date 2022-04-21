package com.example.labs.ui.lab3.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Recipient(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "fio") val fio: String,
    @ColumnInfo(name = "street") val street: String,
    @ColumnInfo(name = "house") val house: Int,
    @ColumnInfo(name = "apartment") val apartment: Int,
    @ColumnInfo(name = "startDate") val startDate: Long,
    @ColumnInfo(name = "duration") val duration: Int,
    @ColumnInfo(name = "deliveryId") val deliveryId: Int
)