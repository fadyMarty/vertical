package com.verticalautomotive.android.presentation.chat_list

import com.verticalautomotive.android.domain.model.Chat

data class ChatListState(
    val chats: List<Chat> = emptyList(),
)
