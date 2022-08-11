
package com.example.android.buconnect.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface ChatDao {

    // The flow always holds/caches latest version of data. Notifies its observers when the
    // data has changed.
    @Query("SELECT * FROM word_table ORDER BY word ASC")
    fun getAlphabetizedWords(): Flow<List<Chat>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Chat)

    @Query("DELETE FROM word_table")
    suspend fun deleteAll()
}
