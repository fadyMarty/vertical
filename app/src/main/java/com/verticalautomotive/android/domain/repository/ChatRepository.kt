package com.verticalautomotive.android.domain.repository

import com.verticalautomotive.android.domain.model.Chat

interface ChatRepository {
    suspend fun getChats(): Result<List<Chat>>
    suspend fun getChatById(id: Int): Result<Chat>
}