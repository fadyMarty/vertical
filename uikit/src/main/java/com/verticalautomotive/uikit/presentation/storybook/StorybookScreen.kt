package com.verticalautomotive.uikit.presentation.storybook

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.verticalautomotive.uikit.R
import com.verticalautomotive.uikit.presentation.components.bottom_bar.BottomBar
import com.verticalautomotive.uikit.presentation.components.bottom_bar.BottomBarItem
import com.verticalautomotive.uikit.presentation.components.buttons.VerticalButton
import com.verticalautomotive.uikit.presentation.components.buttons.VerticalIconButton
import com.verticalautomotive.uikit.presentation.components.buttons.VerticalTextButton
import com.verticalautomotive.uikit.presentation.components.indicator.StatusBar
import com.verticalautomotive.uikit.presentation.components.inputs.Input
import com.verticalautomotive.uikit.presentation.components.inputs.PasswordInput
import com.verticalautomotive.uikit.presentation.components.inputs.transformations.PhoneNumberInputTransformation
import com.verticalautomotive.uikit.presentation.components.inputs.transformations.PhoneNumberOutputTransformation
import com.verticalautomotive.uikit.presentation.components.toolbar.HomeToolbar
import com.verticalautomotive.uikit.presentation.components.toolbar.Toolbar
import com.verticalautomotive.uikit.presentation.navigation.Route

@Composable
fun StorybookScreen() {
    Scaffold(
        contentWindowInsets = WindowInsets.safeDrawing,
        containerColor = Color(0xFFE0E0E0).copy(alpha = 0.81f)
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                StatusBar(
                    pageCount = 4,
                    currentPage = 2
                )
            }
            item {
                VerticalTextButton(
                    modifier = Modifier.fillMaxWidth(),
                    label = "Resend Code",
                    onClick = {},
                    enabled = false
                )
            }
            item {
                VerticalTextButton(
                    label = "Skip",
                    onClick = {},
                    textAlign = TextAlign.Start
                )
            }
            item {
                VerticalButton(
                    modifier = Modifier.fillMaxWidth(),
                    label = "Next",
                    onClick = {}
                )
            }
            item {
                VerticalButton(
                    modifier = Modifier.fillMaxWidth(),
                    label = "Get the code",
                    onClick = {},
                    enabled = false
                )
            }
            item {
                VerticalButton(
                    modifier = Modifier.fillMaxWidth(),
                    label = "Add a car",
                    onClick = {},
                    trailingIcon = ImageVector.vectorResource(R.drawable.ic_add)
                )
            }
            item {
                VerticalIconButton(
                    icon = ImageVector.vectorResource(R.drawable.ic_paperclip),
                    onClick = {}
                )
            }
            item {
                Input(
                    state = rememberTextFieldState("1"),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Phone
                    ),
                    inputTransformation = PhoneNumberInputTransformation(),
                    outputTransformation = PhoneNumberOutputTransformation()
                )
            }
            item {
                Input(
                    state = rememberTextFieldState("15551234567"),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Phone
                    ),
                    inputTransformation = PhoneNumberInputTransformation(),
                    outputTransformation = PhoneNumberOutputTransformation()
                )
            }
            item {
                Input(
                    state = rememberTextFieldState()
                )
            }
            item {
                Input(
                    state = rememberTextFieldState("username@gmail.com")
                )
            }
            item {
                PasswordInput(
                    state = rememberTextFieldState("MDWI#*R*@!! RR"),
                    isPasswordVisible = true,
                    onToggleVisibilityClick = {}
                )
            }
            item {
                PasswordInput(
                    state = rememberTextFieldState("MDWI#*R*@!! RR"),
                    isPasswordVisible = false,
                    onToggleVisibilityClick = {}
                )
            }
            item {
                BottomBar(
                    items = getBottomBarItems(0),
                    onItemClick = {}
                )
            }
            item {
                BottomBar(
                    items = getBottomBarItems(1),
                    onItemClick = {}
                )
            }
            item {
                BottomBar(
                    items = getBottomBarItems(2),
                    onItemClick = {}
                )
            }
            item {
                BottomBar(
                    items = getBottomBarItems(3),
                    onItemClick = {}
                )
            }
            item {
                Toolbar(
                    onBackClick = {},
                    title = "Promotions"
                )
            }
            item {
                Toolbar(
                    onBackClick = {}
                )
            }
            item {
                HomeToolbar(
                    onUserClick = {},
                    onNotificationClick = {},
                    title = "Hello, Michael"
                )
            }
        }
    }
}

@Composable
private fun getBottomBarItems(
    selectedItemIndex: Int,
): List<BottomBarItem<Route>> {
    return listOf(
        BottomBarItem(
            selected = false,
            icon = R.drawable.ic_home,
            label = "Home",
            route = Route.Home
        ),
        BottomBarItem(
            selected = false,
            icon = R.drawable.ic_3dcube,
            label = "Services",
            route = Route.Services
        ),
        BottomBarItem(
            selected = false,
            icon = R.drawable.ic_car,
            label = "Garage",
            route = Route.Garage
        ),
        BottomBarItem(
            selected = false,
            icon = R.drawable.ic_message,
            label = "Chat",
            route = Route.Chat
        )
    ).mapIndexed { index, item ->
        item.copy(
            selected = index == selectedItemIndex
        )
    }
}