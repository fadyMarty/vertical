package com.verticalautomotive.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.verticalautomotive.android.presentation.navigation.NavigationRoot
import com.verticalautomotive.uikit.common.theme.VerticalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VerticalTheme {
                NavigationRoot()
            }
        }
    }
}