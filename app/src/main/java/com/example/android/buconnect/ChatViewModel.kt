
package com.example.android.buconnect

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.android.buconnect.data.Chat
import kotlinx.coroutines.launch


class ChatViewModel(private val repository: ChatRepository) : ViewModel() {


    val allWords: LiveData<List<Chat>> = repository.allWords.asLiveData()

    fun insert(word: Chat) = viewModelScope.launch {
        repository.insert(word)
    }
}

class WordViewModelFactory(private val repository: ChatRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ChatViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ChatViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
