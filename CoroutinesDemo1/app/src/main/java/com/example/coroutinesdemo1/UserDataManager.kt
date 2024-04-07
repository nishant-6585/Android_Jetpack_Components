package com.example.coroutinesdemo1

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class UserDataManager {

    // Unstructured Concurrency
    suspend fun getTotalUserAccount(): Int {
        var count = 0

        val deferred1 = CoroutineScope(Dispatchers.IO).async {
            delay(1000)
            count = 50
            return@async count
        }

        val deferred = CoroutineScope(Dispatchers.IO).async {
            delay(1000)
            return@async 70
        }
        return deferred1.await() + deferred.await()
    }
}