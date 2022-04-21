package com.example.labs.ui.lab3

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.labs.App
import com.example.labs.ui.lab3.db.AppDatabaseBuilder
import com.example.labs.ui.lab3.entities.Delivery
import com.example.labs.ui.lab3.entities.Publish
import com.example.labs.ui.lab3.entities.PublishType
import com.example.labs.ui.lab3.entities.Recipient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

class Lab3ViewModel : ViewModel() {

    private val _list = MutableLiveData<List<Recipient>>()
    val list: LiveData<List<Recipient>> = _list

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val db = AppDatabaseBuilder(App.context).build()

            db.publishDao().apply {
                if (this.getAll().isEmpty()) {
                    this.insertAll(Publish(0, "Хоббит", PublishType.Journal, 0, 10))
                    this.insertAll(Publish(0, "Звездные войны", PublishType.Magazine, 0, 8))
                }
            }

            db.deliveryDao().apply {
                if (this.getAll().isEmpty()) {
                    this.insertAll(Delivery(0, "Uber"))
                }
            }

            db.recipientDao().apply {
                insertAll(
                    Recipient(
                        0,
                        "Яковлев Андрей Александрович",
                        "Ленина",
                        1,
                        5,
                        Date().time,
                        12,
                        1
                    )
                )

                _list.postValue(getAll())
            }
        }
    }
}