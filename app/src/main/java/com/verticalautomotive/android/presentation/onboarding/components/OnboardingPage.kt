package com.verticalautomotive.android.presentation.onboarding.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.verticalautomotive.android.R
import com.verticalautomotive.android.presentation.onboarding.OnboardingItem
import com.verticalautomotive.uikit.common.theme.VerticalTheme

@Composable
fun OnboardingPage(
    item: OnboardingItem,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(464.dp),
            painter = painterResource(item.image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alignment = Alignment.BottomCenter
        )
        Spacer(modifier = Modifier.height(43.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = item.title,
                style = VerticalTheme.typography.h1
            )
            Text(
                text = item.description,
                style = VerticalTheme.typography.mainText
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun OnboardingPagePreview() {
    VerticalTheme {
        OnboardingPage(
            item = OnboardingItem(
                image = R.drawable.img_onboarding_1,
                title = "Your Car Deserves the Best Care",
                description = "Quick booking, transparent pricing, and reliable mechanics - all in one app."
            )
        )
    }
}