package com.example.android.roomwordssample

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.android.buconnect.WordRoomDatabase
import com.example.android.buconnect.data.Chat
import com.example.android.buconnect.data.ChatDao
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException


@RunWith(AndroidJUnit4::class)
class WordDaoTest {

    private lateinit var wordDao: ChatDao
    private lateinit var db: WordRoomDatabase

    @Before
    fun createDb() {
        val context: Context = ApplicationProvider.getApplicationContext()

        db = Room.inMemoryDatabaseBuilder(context, WordRoomDatabase::class.java)
            .allowMainThreadQueries()
            .build()
        wordDao = db.wordDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun insertAndGetWord() = runBlocking {
        val word = Chat("word")
        wordDao.insert(word)
        val allWords = wordDao.getAlphabetizedWords().first()
        assertEquals(allWords[0].word, word.word)
    }

    @Test
    @Throws(Exception::class)
    fun getAllWords() = runBlocking {
        val word = Chat("aaa")
        wordDao.insert(word)
        val word2 = Chat("bbb")
        wordDao.insert(word2)
        val allWords = wordDao.getAlphabetizedWords().first()
        assertEquals(allWords[0].word, word.word)
        assertEquals(allWords[1].word, word2.word)
    }

    @Test
    @Throws(Exception::class)
    fun deleteAll() = runBlocking {
        val word = Chat("word")
        wordDao.insert(word)
        val word2 = Chat("word2")
        wordDao.insert(word2)
        wordDao.deleteAll()
        val allWords = wordDao.getAlphabetizedWords().first()
        assertTrue(allWords.isEmpty())
    }
}
