package za.co.quantive.app.presentation.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import za.co.quantive.app.presentation.ui.theme.*

data class Feature(
    val id: String,
    val title: String,
    val description: String,
    val icon: ImageVector
)

@Composable
fun FeatureCard(
    feature: Feature,
    isSelected: Boolean = false,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val targetScale = if (isSelected) 1.05f else 1f
    val scale by animateFloatAsState(
        targetValue = targetScale,
        animationSpec = tween(durationMillis = 200),
        label = "scale"
    )

    val featureColor = FeatureColors[feature.title] ?: MaterialTheme.colorScheme.primary
    val backgroundColor by animateColorAsState(
        targetValue = if (isSelected) featureColor else MaterialTheme.colorScheme.surface,
        animationSpec = tween(durationMillis = 200),
        label = "backgroundColor"
    )

    val contentColor by animateColorAsState(
        targetValue = if (isSelected) MaterialTheme.colorScheme.onPrimary else featureColor,
        animationSpec = tween(durationMillis = 200),
        label = "contentColor"
    )

    Card(
        modifier = modifier
            .width(160.dp)
            .height(140.dp)
            .scale(scale)
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(
            defaultElevation = if (isSelected) 12.dp else 6.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = backgroundColor,
            contentColor = contentColor
        ),
        shape = ExpressiveShapes.featureCard
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Icon(
                imageVector = feature.icon,
                contentDescription = null,
                modifier = Modifier.size(32.dp),
                tint = contentColor
            )

            Text(
                text = feature.title,
                style = ExpressiveTextStyles.featureTitle,
                textAlign = TextAlign.Center,
                color = contentColor
            )
        }
    }
}

@Composable
fun SelectedFeatureDetail(
    feature: Feature,
    modifier: Modifier = Modifier
) {
    val featureColor = FeatureColors[feature.title] ?: MaterialTheme.colorScheme.primary

    Card(
        modifier = modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = featureColor.copy(alpha = 0.1f)
        ),
        shape = ExpressiveShapes.surfaceVariant
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Icon(
                    imageVector = feature.icon,
                    contentDescription = null,
                    modifier = Modifier.size(28.dp),
                    tint = featureColor
                )
                Text(
                    text = feature.title,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = featureColor
                )
            }

            Text(
                text = feature.description,
                style = ExpressiveTextStyles.featureDescription,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f)
            )
        }
    }
}