package com.verticalautomotive.android.presentation.chat_list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.verticalautomotive.android.R
import com.verticalautomotive.android.domain.model.Chat
import com.verticalautomotive.uikit.common.theme.VerticalTheme

@Composable
fun ChatListItem(
    chat: Chat,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .size(44.dp)
                    .border(
                        width = 1.dp,
                        color = VerticalTheme.colorScheme.strokeGrey,
                        shape = CircleShape
                    )
                    .clip(CircleShape),
                painter = painterResource(chat.image),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier.weight(1f),
                        text = chat.title,
                        style = VerticalTheme.typography.h4,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = chat.lastMessageTime,
                        style = VerticalTheme.typography.signature
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier.weight(1f),
                        text = chat.lastMessageContent,
                        style = VerticalTheme.typography.mainText,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    when {
                        chat.unreadCount > 0 -> {
                            Box(
                                modifier = Modifier.size(24.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(16.dp)
                                        .clip(CircleShape)
                                        .background(VerticalTheme.colorScheme.mainButton),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = chat.unreadCount.toString(),
                                        style = VerticalTheme.typography.indicator,
                                        color = VerticalTheme.colorScheme.onMainButton
                                    )
                                }
                            }
                        }
                        chat.isRead -> {
                            Icon(
                                modifier = Modifier.size(24.dp),
                                imageVector = ImageVector.vectorResource(R.drawable.ic_done_all),
                                contentDescription = null,
                                tint = VerticalTheme.colorScheme.success
                            )
                        }
                    }
                }
            }
        }
        HorizontalDivider(
            thickness = 1.dp,
            color = VerticalTheme.colorScheme.strokeGrey
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ChatListItemPreview() {
    VerticalTheme {
        ChatListItem(
            chat = Chat(
                id = 1,
                image = R.drawable.img_vertical_automotive_support,
                title = "Support",
                lastMessageContent = "We are glad to see you here! \uD83C\uDF89 \u2028Need help? We are always here - write to support. We wish you a pleasant use! May each of your orders bring you joy!",
                lastMessageTime = "11:32",
                isRead = false,
                unreadCount = 1
            ),
            onClick = {}
        )
    }
}