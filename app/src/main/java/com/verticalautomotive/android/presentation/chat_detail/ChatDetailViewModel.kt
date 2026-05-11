package com.verticalautomotive.android.presentation.chat_detail

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class ChatDetailViewModel(
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val chatId = savedStateHandle.get<Int>("chatId")

    init {
        Log.d("ChatDetailViewModel", chatId.toString())
    }
}