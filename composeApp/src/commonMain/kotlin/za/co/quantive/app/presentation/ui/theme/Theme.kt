package za.co.quantive.app.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

// Light Color Scheme - Expressive and Vibrant
private val LightColorScheme = lightColorScheme(
    primary = QuantiveBlue,
    onPrimary = Neutral100,
    primaryContainer = QuantiveBlueLight.copy(alpha = 0.12f),
    onPrimaryContainer = QuantiveBlueDark,

    secondary = QuantiveOrange,
    onSecondary = Neutral100,
    secondaryContainer = QuantiveOrangeLight.copy(alpha = 0.12f),
    onSecondaryContainer = QuantiveOrangeDark,

    tertiary = QuantivePurple,
    onTertiary = Neutral100,
    tertiaryContainer = QuantivePurpleLight.copy(alpha = 0.12f),
    onTertiaryContainer = QuantivePurpleDark,

    error = ErrorRed,
    onError = Neutral100,
    errorContainer = ErrorRed.copy(alpha = 0.12f),
    onErrorContainer = ErrorRed,

    background = Neutral100,
    onBackground = Neutral20,

    surface = Neutral100,
    onSurface = Neutral20,
    surfaceVariant = SurfaceVariant,
    onSurfaceVariant = Neutral40,

    inverseSurface = Neutral20,
    inverseOnSurface = Neutral95,

    outline = Neutral70,
    outlineVariant = Neutral90,

    scrim = Neutral20,
)

// Dark Color Scheme - Expressive and Balanced
private val DarkColorScheme = darkColorScheme(
    primary = QuantiveBlueLight,
    onPrimary = Neutral20,
    primaryContainer = QuantiveBlueDark.copy(alpha = 0.3f),
    onPrimaryContainer = QuantiveBlueLight,

    secondary = QuantiveOrangeLight,
    onSecondary = Neutral20,
    secondaryContainer = QuantiveOrangeDark.copy(alpha = 0.3f),
    onSecondaryContainer = QuantiveOrangeLight,

    tertiary = QuantivePurpleLight,
    onTertiary = Neutral20,
    tertiaryContainer = QuantivePurpleDark.copy(alpha = 0.3f),
    onTertiaryContainer = QuantivePurpleLight,

    error = ErrorRed,
    onError = Neutral100,
    errorContainer = ErrorRed.copy(alpha = 0.3f),
    onErrorContainer = ErrorRed,

    background = Neutral10,
    onBackground = Neutral95,

    surface = Neutral20,
    onSurface = Neutral95,
    surfaceVariant = Neutral30,
    onSurfaceVariant = Neutral80,

    inverseSurface = Neutral90,
    inverseOnSurface = Neutral30,

    outline = Neutral60,
    outlineVariant = Neutral30,

    scrim = Neutral90,
)

// Gradient Extensions
@Composable
fun ColorScheme.primaryGradient(): Brush {
    return Brush.verticalGradient(
        colors = if (isSystemInDarkTheme()) {
            listOf(QuantiveBlueDark, QuantiveBlue)
        } else {
            PrimaryGradient
        }
    )
}

@Composable
fun ColorScheme.secondaryGradient(): Brush {
    return Brush.verticalGradient(
        colors = if (isSystemInDarkTheme()) {
            listOf(QuantiveOrangeDark, QuantiveOrange)
        } else {
            SecondaryGradient
        }
    )
}

@Composable
fun ColorScheme.tertiaryGradient(): Brush {
    return Brush.verticalGradient(
        colors = if (isSystemInDarkTheme()) {
            listOf(QuantivePurpleDark, QuantivePurple)
        } else {
            TertiaryGradient
        }
    )
}

// Main Theme Composable
@Composable
fun QuantiveTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = QuantiveTypography,
        shapes = QuantiveShapes,
        content = content
    )
}