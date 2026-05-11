package com.verticalautomotive.android.presentation.onboarding

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.displayCutout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.union
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.verticalautomotive.android.R
import com.verticalautomotive.android.presentation.onboarding.components.OnboardingPage
import com.verticalautomotive.uikit.common.theme.VerticalTheme
import com.verticalautomotive.uikit.presentation.components.buttons.VerticalButton
import com.verticalautomotive.uikit.presentation.components.buttons.VerticalTextButton
import com.verticalautomotive.uikit.presentation.components.indicator.StatusBar
import kotlinx.coroutines.launch
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun OnboardingRoot(
    viewModel: OnboardingViewModel = koinViewModel(),
    onSkipClick: () -> Unit,
) {
    OnboardingScreen(
        onEvent = { event ->
            when (event) {
                OnboardingEvent.OnSkipClick -> onSkipClick()
            }
            viewModel.onEvent(event)
        }
    )
}

@Composable
fun OnboardingScreen(
    onEvent: (OnboardingEvent) -> Unit,
) {
    val pages = remember {
        listOf(
            OnboardingItem(
                image = R.drawable.img_onboarding_1,
                title = "Your Car Deserves the Best Care",
                description = "Quick booking, transparent pricing, and reliable mechanics - all in one app."
            ),
            OnboardingItem(
                image = R.drawable.img_onboarding_2,
                title = "Book in 30 Seconds",
                description = "Select a service, choose a convenient time - and you're done! No waiting lines."
            ),
            OnboardingItem(
                image = R.drawable.img_onboarding_3,
                title = "Track Every Step",
                description = "Get real-time notifications about repair progress, completion."
            ),
            OnboardingItem(
                image = R.drawable.img_onboarding_4,
                title = "All Set!",
                description = "Get started now - book a service or run a quick diagnostic."
            )
        )
    }
    val pagerState = rememberPagerState { 4 }
    val scope = rememberCoroutineScope()

    Scaffold(
        contentWindowInsets = WindowInsets.navigationBars.union(
            WindowInsets.displayCutout
        )
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            HorizontalPager(
                modifier = Modifier.fillMaxSize(),
                state = pagerState
            ) { index ->
                OnboardingPage(
                    modifier = Modifier.fillMaxSize(),
                    item = pages[index]
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .padding(top = 464.dp, bottom = 55.dp)
            ) {
                if (pagerState.currentPage != 3) {
                    VerticalTextButton(
                        modifier = Modifier.align(Alignment.End),
                        label = "Skip",
                        onClick = {
                            onEvent(OnboardingEvent.OnSkipClick)
                        },
                        textAlign = TextAlign.Start
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(24.dp)
                ) {
                    VerticalButton(
                        modifier = Modifier.fillMaxWidth(),
                        label = if (pagerState.currentPage == 3) {
                            "Enter by phone number"
                        } else "Next",
                        onClick = {
                            if (pagerState.currentPage == 3) {
                                onEvent(OnboardingEvent.OnSkipClick)
                            } else {
                                scope.launch {
                                    pagerState.animateScrollToPage(
                                        page = pagerState.currentPage + 1
                                    )
                                }
                            }
                        }
                    )
                    StatusBar(
                        pageCount = pagerState.pageCount,
                        currentPage = pagerState.currentPage
                    )
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun OnboardingScreenPreview() {
    VerticalTheme {
        OnboardingScreen(
            onEvent = {}
        )
    }
}