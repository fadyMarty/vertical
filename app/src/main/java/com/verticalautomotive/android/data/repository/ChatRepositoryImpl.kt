package com.verticalautomotive.android.data.repository

import com.verticalautomotive.android.R
import com.verticalautomotive.android.common.util.safeCall
import com.verticalautomotive.android.domain.model.Chat
import com.verticalautomotive.android.domain.repository.ChatRepository

class ChatRepositoryImpl : ChatRepository {

    private val chats = mutableListOf(
        Chat(
            id = 1,
            image = R.drawable.img_vertical_automotive_support,
            title = "Support",
            lastMessageContent = "We are glad to see you here! \uD83C\uDF89 \u2028Need help? We are always here - write to support. We wish you a pleasant use! May each of your orders bring you joy!",
            lastMessageTime = "11:32",
            isRead = false,
            unreadCount = 1
        ),
        Chat(
            id = 2,
            image = R.drawable.img_volkswagen_support,
            title = "Support",
            lastMessageContent = "We are glad to see you here! \uD83C\uDF89 \u2028Need help? We are always here - write to support. We wish you a pleasant use! May each of your orders bring you joy!",
            lastMessageTime = "11:32",
            isRead = false,
            unreadCount = 0
        ),
        Chat(
            id = 3,
            image = R.drawable.img_tesla_support,
            title = "Support",
            lastMessageContent = "We are glad to see you here! \uD83C\uDF89 \u2028Need help? We are always here - write to support. We wish you a pleasant use! May each of your orders bring you joy!",
            lastMessageTime = "11:32",
            isRead = true,
            unreadCount = 0
        )
    )

    override suspend fun getChats(): Result<List<Chat>> {
        return safeCall { chats }
    }

    override suspend fun getChatById(id: Int): Result<Chat> {
        return safeCall {
            chats.first { it.id == id }
        }
    }
}