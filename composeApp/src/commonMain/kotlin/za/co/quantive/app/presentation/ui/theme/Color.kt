package za.co.quantive.app.presentation.ui.theme

import androidx.compose.ui.graphics.Color

// Material 3 Expressive Colors
// Primary Brand Colors - Vibrant Blue with Expressive Variations
val QuantiveBlue = Color(0xFF0066CC)
val QuantiveBlueLight = Color(0xFF4D94FF)
val QuantiveBlueDark = Color(0xFF0052A3)

// Secondary Colors - Warm Orange with Expressive Qualities
val QuantiveOrange = Color(0xFFFF6B35)
val QuantiveOrangeLight = Color(0xFFFF9A7D)
val QuantiveOrangeDark = Color(0xFFE55A2B)

// Tertiary Colors - Purple for Accent
val QuantivePurple = Color(0xFF9C27B0)
val QuantivePurpleLight = Color(0xFFBA68C8)
val QuantivePurpleDark = Color(0xFF7B1FA2)

// Expressive Surface Colors
val SurfaceVariant = Color(0xFFF8F9FA)
val SurfaceContainer = Color(0xFFFFFFFF)
val SurfaceContainerHigh = Color(0xFFF5F5F5)
val SurfaceContainerHighest = Color(0xFFEEEEEE)

// Expressive State Colors
val SuccessGreen = Color(0xFF4CAF50)
val WarningYellow = Color(0xFFFFC107)
val ErrorRed = Color(0xFFE53935)
val InfoBlue = Color(0xFF2196F3)

// Neutral Colors with Better Contrast
val Neutral10 = Color(0xFF000000)
val Neutral20 = Color(0xFF1A1A1A)
val Neutral30 = Color(0xFF333333)
val Neutral40 = Color(0xFF4D4D4D)
val Neutral50 = Color(0xFF666666)
val Neutral60 = Color(0xFF808080)
val Neutral70 = Color(0xFF999999)
val Neutral80 = Color(0xFFB3B3B3)
val Neutral90 = Color(0xFFCCCCCC)
val Neutral95 = Color(0xFFE6E6E6)
val Neutral99 = Color(0xFFF5F5F5)
val Neutral100 = Color(0xFFFFFFFF)

// Expressive Gradient Colors
val PrimaryGradient = listOf(QuantiveBlue, QuantiveBlueLight)
val SecondaryGradient = listOf(QuantiveOrange, QuantiveOrangeLight)
val TertiaryGradient = listOf(QuantivePurple, QuantivePurpleLight)

// Custom Expressive Colors for Features
val FeatureColors = mapOf(
    "Cross-Platform" to QuantiveBlue,
    "Modern UI" to QuantiveOrange,
    "Performance" to QuantivePurple,
    "Secure" to SuccessGreen,
    "Scalable" to InfoBlue,
    "Innovative" to WarningYellow
)

// Showcase Colors
val ShowcaseColors = mapOf(
    "Analytics" to QuantiveBlue,
    "Dashboard" to QuantiveOrange,
    "Reports" to QuantivePurple,
    "Settings" to ErrorRed
)