package za.co.quantive.app

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import org.koin.compose.KoinApplication
import za.co.quantive.app.di.appModule
import za.co.quantive.app.presentation.ui.screens.SimpleHomeScreen
import za.co.quantive.app.presentation.ui.theme.QuantiveTheme

@Composable
fun App() {
    KoinApplication(
        application = {
            modules(appModule)
        }
    ) {
        QuantiveTheme(
            darkTheme = isSystemInDarkTheme()
        ) {
            SimpleHomeScreen()
        }
    }
}