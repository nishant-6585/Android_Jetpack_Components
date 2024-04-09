package com.example.roomdemo.db

import javax.inject.Inject

class SubscriberRepository @Inject constructor(
    private val dao: SubscriberDao
) {

    val subscribers = dao.getALlSubscribers()

    suspend fun insert(subscriber: Subscriber): Long {
        return dao.insertSubscriber(subscriber)
    }

    suspend fun update(subscriber: Subscriber): Int {
        return dao.updateSubscriber(subscriber)
    }

    suspend fun delete(subscriber: Subscriber) {
        dao.deleteSubscriber(subscriber)
    }

    suspend fun deleteALl() {
        dao.deleteAll()
    }
}