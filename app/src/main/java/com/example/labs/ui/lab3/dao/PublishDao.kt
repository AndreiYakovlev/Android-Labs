package com.example.labs.ui.lab3.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.labs.ui.lab3.entities.Publish

@Dao
interface PublishDao {
    @Query("SELECT * FROM Publish")
    fun getAll(): List<Publish>

    @Query("SELECT * FROM Publish WHERE id IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<Publish>

    @Insert
    fun insertAll(vararg users: Publish)

    @Delete
    fun delete(user: Publish)
}