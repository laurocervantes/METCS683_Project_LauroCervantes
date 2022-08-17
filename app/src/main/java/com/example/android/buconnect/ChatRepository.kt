package com.example.android.buconnect

import androidx.annotation.WorkerThread
import com.example.android.buconnect.data.Chat
import com.example.android.buconnect.data.ChatDao
import kotlinx.coroutines.flow.Flow


class ChatRepository(private val chatDao: ChatDao) {

    val allWords: Flow<List<Chat>> = chatDao.getAlphabetizedWords()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(word: Chat) {
        chatDao.insert(word)
    }
}
