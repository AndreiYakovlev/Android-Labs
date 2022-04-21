package com.example.labs.ui.lab3.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.labs.ui.lab3.entities.Recipient

@Dao
interface RecipientDao {
    @Query("SELECT * FROM Recipient")
    fun getAll(): List<Recipient>

    @Query("SELECT * FROM Recipient WHERE id IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<Recipient>

    @Insert
    fun insertAll(vararg users: Recipient)

    @Delete
    fun delete(user: Recipient)
}