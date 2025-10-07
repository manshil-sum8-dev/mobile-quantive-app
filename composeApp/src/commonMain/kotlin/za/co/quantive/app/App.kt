package za.co.quantive.app

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import za.co.quantive.app.presentation.ui.screens.SimpleHomeScreen
import za.co.quantive.app.presentation.ui.theme.QuantiveTheme

@Composable
fun App() {
    QuantiveTheme(
        darkTheme = isSystemInDarkTheme()
    ) {
        SimpleHomeScreen()
    }
}