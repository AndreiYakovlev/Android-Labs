package com.example.labs.ui.lab3.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Delivery(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "company") val company: String
)