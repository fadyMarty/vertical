package com.verticalautomotive.uikit.presentation.components.inputs

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.verticalautomotive.uikit.common.theme.VerticalTheme

@Composable
fun InputLayout(
    modifier: Modifier = Modifier,
    label: String? = null,
    input: @Composable (Modifier) -> Unit,
) {
    val inputStyleModifier = Modifier
        .fillMaxWidth()
        .height(48.dp)
        .border(
            width = 1.dp,
            color = VerticalTheme.colorScheme.strokeGrey,
            shape = RoundedCornerShape(16.dp)
        )
        .padding(horizontal = 12.dp)

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        if (label != null) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = label,
                style = VerticalTheme.typography.input
            )
        }
        input(inputStyleModifier)
    }
}