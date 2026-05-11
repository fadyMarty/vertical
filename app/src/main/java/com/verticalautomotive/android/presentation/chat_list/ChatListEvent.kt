package com.verticalautomotive.android.presentation.chat_list

import com.verticalautomotive.android.domain.model.Chat

sealed interface ChatListEvent {
    data object OnBackClick : ChatListEvent
    data class OnChatClick(val chat: Chat) : ChatListEvent
}