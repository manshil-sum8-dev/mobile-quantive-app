package za.co.quantive.app.presentation.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

// Material 3 Expressive Shapes
val QuantiveShapes = Shapes(
    // Expressive Corner Radius Values
    extraSmall = RoundedCornerShape(4.dp),
    small = RoundedCornerShape(8.dp),
    medium = RoundedCornerShape(12.dp),
    large = RoundedCornerShape(20.dp),  // More expressive than default 16dp
    extraLarge = RoundedCornerShape(32.dp) // More dramatic than default 28dp
)

// Custom Expressive Shapes for Specific Components
val ExpressiveShapes = ExpressiveComponentShapes(
    // Card Shapes
    featureCard = RoundedCornerShape(16.dp),
    showcaseCard = RoundedCornerShape(12.dp),
    statCard = RoundedCornerShape(20.dp),
    heroCard = RoundedCornerShape(28.dp),

    // Button Shapes
    primaryButton = RoundedCornerShape(12.dp),
    secondaryButton = RoundedCornerShape(20.dp),
    tertiaryButton = RoundedCornerShape(50.dp), // Fully rounded

    // Dialog and Bottom Sheet Shapes
    dialog = RoundedCornerShape(28.dp),
    bottomSheet = RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp),

    // Chip and Badge Shapes
    chip = RoundedCornerShape(50.dp), // Fully rounded
    badge = RoundedCornerShape(8.dp),

    // Container Shapes
    container = RoundedCornerShape(16.dp),
    surfaceVariant = RoundedCornerShape(12.dp)
)

data class ExpressiveComponentShapes(
    val featureCard: RoundedCornerShape,
    val showcaseCard: RoundedCornerShape,
    val statCard: RoundedCornerShape,
    val heroCard: RoundedCornerShape,
    val primaryButton: RoundedCornerShape,
    val secondaryButton: RoundedCornerShape,
    val tertiaryButton: RoundedCornerShape,
    val dialog: RoundedCornerShape,
    val bottomSheet: RoundedCornerShape,
    val chip: RoundedCornerShape,
    val badge: RoundedCornerShape,
    val container: RoundedCornerShape,
    val surfaceVariant: RoundedCornerShape
)