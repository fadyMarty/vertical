package com.verticalautomotive.android.domain.model

import androidx.annotation.DrawableRes

data class Chat(
    val id: Int,
    @DrawableRes val image: Int,
    val title: String,
    val lastMessageContent: String,
    val lastMessageTime: String,
    val isRead: Boolean,
    val unreadCount: Int,
)