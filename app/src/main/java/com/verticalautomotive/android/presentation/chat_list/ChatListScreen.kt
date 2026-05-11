package com.verticalautomotive.android.presentation.chat_list

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.displayCutout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.union
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.verticalautomotive.android.presentation.chat_list.components.ChatListItem
import com.verticalautomotive.uikit.common.theme.VerticalTheme
import com.verticalautomotive.uikit.presentation.components.toolbar.Toolbar
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ChatListRoot(
    viewModel: ChatListViewModel = koinViewModel(),
    onBackClick: () -> Unit,
    onChatClick: (Int) -> Unit,
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    ChatListScreen(
        state = state,
        onEvent = { event ->
            when (event) {
                ChatListEvent.OnBackClick -> onBackClick()
                is ChatListEvent.OnChatClick -> onChatClick(event.id)
            }
        }
    )
}

@Composable
fun ChatListScreen(
    state: ChatListState,
    onEvent: (ChatListEvent) -> Unit,
) {
    Scaffold(
        contentWindowInsets = WindowInsets.statusBars.union(
            WindowInsets.displayCutout
        ),
        topBar = {
            Toolbar(
                modifier = Modifier.padding(
                    top = 16.dp,
                    bottom = 8.dp
                ),
                title = "Chat",
                onBackClick = {
                    onEvent(ChatListEvent.OnBackClick)
                }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(
                horizontal = 16.dp,
                vertical = 24.dp
            )
        ) {
            items(state.chats) { chat ->
                ChatListItem(
                    chat = chat,
                    onClick = {
                        onEvent(ChatListEvent.OnChatClick(chat.id))
                    }
                )
            }
        }
    }
}

@Preview
@Composable
private fun ChatListScreenPreview() {
    VerticalTheme {
        ChatListScreen(
            state = ChatListState(),
            onEvent = {}
        )
    }
}