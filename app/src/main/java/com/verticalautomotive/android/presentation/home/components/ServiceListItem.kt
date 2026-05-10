package com.verticalautomotive.android.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.verticalautomotive.android.R
import com.verticalautomotive.android.domain.model.Service
import com.verticalautomotive.uikit.common.theme.VerticalTheme

@Composable
fun ServiceListItem(
    service: Service,
    onAddClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .width(170.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(VerticalTheme.colorScheme.widgetBackground)
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier.size(56.dp),
                painter = painterResource(service.icon),
                contentDescription = null
            )
            Text(
                modifier = Modifier.weight(1f),
                text = service.title,
                style = VerticalTheme.typography.signature
            )
        }
        HorizontalDivider(
            thickness = 1.dp,
            color = VerticalTheme.colorScheme.strokeGrey
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                modifier = Modifier
                    .weight(1f)
                    .height(32.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(VerticalTheme.colorScheme.mainButton)
                    .clickable(onClick = onAddClick),
                horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier.size(16.dp),
                    imageVector = ImageVector.vectorResource(R.drawable.ic_add),
                    contentDescription = null,
                    tint = VerticalTheme.colorScheme.onMainButton
                )
                Text(
                    text = "${service.price} $",
                    style = VerticalTheme.typography.signature,
                    color = VerticalTheme.colorScheme.onMainButton
                )
            }
            Row(
                modifier = Modifier
                    .size(63.dp, 32.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(VerticalTheme.colorScheme.onBackground),
                horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier.size(16.dp),
                    imageVector = ImageVector.vectorResource(R.drawable.ic_timer),
                    contentDescription = null,
                    tint = VerticalTheme.colorScheme.background
                )
                Text(
                    text = "${service.duration} h",
                    style = VerticalTheme.typography.signature,
                    color = VerticalTheme.colorScheme.background
                )
            }
        }
    }
}

@Preview
@Composable
private fun ServiceListItemPreview() {
    VerticalTheme {
        ServiceListItem(
            service = Service(
                title = "Brakes and rotors",
                icon = R.drawable.img_brakes_service,
                price = 100,
                duration = 2
            ),
            onAddClick = {}
        )
    }
}