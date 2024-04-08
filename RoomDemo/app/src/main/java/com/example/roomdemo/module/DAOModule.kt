package com.example.roomdemo.module

import android.content.Context
import com.example.roomdemo.db.SubscriberDao
import com.example.roomdemo.db.SubscriberDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DAOModule () {
    @Provides
    @Singleton
    fun getSubscriberDAO(@ApplicationContext context: Context): SubscriberDao {
        return SubscriberDatabase.getInstance(context = context).subscriberDAO
    }

}