package com.example.labs.ui.lab3.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.labs.ui.lab3.dao.DeliveryDao
import com.example.labs.ui.lab3.dao.PublishDao
import com.example.labs.ui.lab3.dao.RecipientDao
import com.example.labs.ui.lab3.entities.Delivery
import com.example.labs.ui.lab3.entities.Publish
import com.example.labs.ui.lab3.entities.Recipient

@Database(entities = [Recipient::class, Publish::class, Delivery::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun recipientDao(): RecipientDao
    abstract fun deliveryDao(): DeliveryDao
    abstract fun publishDao(): PublishDao
}

class AppDatabaseBuilder(private val applicationContext: Context) {
    fun build(): AppDatabase {
        return Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database"
        ).fallbackToDestructiveMigration().build()
    }
}