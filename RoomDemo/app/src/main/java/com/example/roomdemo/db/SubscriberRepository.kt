package com.example.roomdemo.db

import javax.inject.Inject

class SubscriberRepository @Inject constructor(
    private val dao: SubscriberDao
) {

    val subscribers = dao.getALlSubscribers()

    suspend fun insert(subscriber: Subscriber) {
        dao.insertSubscriber(subscriber)
    }

    suspend fun update(subscriber: Subscriber) {
        dao.updateSubscriber(subscriber)
    }

    suspend fun delete(subscriber: Subscriber) {
        dao.deleteSubscriber(subscriber)
    }

    suspend fun deleteALl() {
        dao.deleteAll()
    }
}