package com.example.labs.ui.lab3.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.labs.ui.lab3.entities.Delivery

@Dao
interface DeliveryDao {
    @Query("SELECT * FROM Delivery")
    fun getAll(): List<Delivery>

    @Query("SELECT * FROM Delivery WHERE id IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<Delivery>

    @Insert
    fun insertAll(vararg users: Delivery)

    @Delete
    fun delete(user: Delivery)
}