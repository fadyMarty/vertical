package com.verticalautomotive.android.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.displayCutout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.union
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.verticalautomotive.android.R
import com.verticalautomotive.android.presentation.home.components.ServiceListItem
import com.verticalautomotive.uikit.common.theme.Gilroy
import com.verticalautomotive.uikit.common.theme.VerticalTheme
import com.verticalautomotive.uikit.presentation.components.buttons.VerticalButton
import com.verticalautomotive.uikit.presentation.components.toolbar.HomeToolbar
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeRoot(
    viewModel: HomeViewModel = koinViewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    HomeScreen(
        state = state
    )
}

@Composable
fun HomeScreen(
    state: HomeState,
) {
    Scaffold(
        contentWindowInsets = WindowInsets.statusBars.union(
            WindowInsets.displayCutout
        ),
        topBar = {
            HomeToolbar(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(VerticalTheme.colorScheme.onBackground)
                    .padding(vertical = 16.dp),
                title = "Hello, Michael",
                onUserClick = {},
                onNotificationClick = {}
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Image(
                modifier = Modifier
                    .offset(y = (-40).dp)
                    .fillMaxWidth(),
                painter = painterResource(R.drawable.img_home_background),
                contentDescription = null,
                contentScale = ContentScale.FillWidth
            )
            Column(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 12.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            modifier = Modifier.weight(1f),
                            text = "Popular services",
                            style = VerticalTheme.typography.h2
                        )
                        Text(
                            text = "All",
                            style = TextStyle(
                                fontFamily = Gilroy,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp,
                                lineHeight = 20.sp,
                                letterSpacing = 0.sp,
                                color = VerticalTheme.colorScheme.linkText
                            )
                        )
                    }
                    LazyRow(
                        modifier = Modifier.fillMaxWidth(),
                        contentPadding = PaddingValues(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(state.services) { service ->
                            ServiceListItem(
                                service = service,
                                onAddClick = {}
                            )
                        }
                    }
                }
                VerticalButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .padding(top = 16.dp, bottom = 32.dp),
                    label = "Sign up for a service",
                    onClick = {}
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    VerticalTheme {
        HomeScreen(
            state = HomeState()
        )
    }
}