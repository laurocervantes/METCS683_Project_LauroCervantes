
package com.example.android.buconnect

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class ChatsApplication : Application() {
    val applicationScope = CoroutineScope(SupervisorJob())


    val database by lazy { WordRoomDatabase.getDatabase(this, applicationScope) }
    val repository by lazy { ChatRepository(database.wordDao()) }
}
