package com.verticalautomotive.android.presentation.chat_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.verticalautomotive.android.domain.repository.ChatRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ChatListViewModel(
    private val chatRepository: ChatRepository,
) : ViewModel() {

    private val _state = MutableStateFlow(ChatListState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            chatRepository.getChats()
                .onSuccess { chats ->
                    _state.update {
                        it.copy(
                            chats = chats
                        )
                    }
                }
        }
    }
}