package com.verticalautomotive.android.presentation.chat_list

sealed interface ChatListEvent {
    data object OnBackClick : ChatListEvent
    data class OnChatClick(val id: Int) : ChatListEvent
}