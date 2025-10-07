package za.co.quantive.app.data.model

import kotlinx.serialization.Serializable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

@Serializable
data class FeatureResponse(
    val id: String,
    val title: String,
    val description: String,
    val iconName: String,
    val category: String,
    val isEnabled: Boolean = true,
    val priority: Int = 0
)

@Serializable
data class ShowcaseResponse(
    val id: String,
    val title: String,
    val subtitle: String,
    val description: String,
    val imageUrl: String? = null
)

@Serializable
data class StatsResponse(
    val uptime: Double,
    val supportHours: Int,
    val userCount: Double,
    val lastUpdated: String
)

// Domain Models
data class Feature(
    val id: String,
    val title: String,
    val description: String,
    val icon: ImageVector,
    val category: String,
    val isEnabled: Boolean,
    val priority: Int
)

data class ShowcaseItem(
    val id: String,
    val title: String,
    val subtitle: String,
    val description: String,
    val imageUrl: String?
)

data class Stats(
    val uptime: Double,
    val supportHours: Int,
    val userCount: Double,
    val lastUpdated: String
)

// Mappers
fun FeatureResponse.toDomain(): Feature {
    val icon = when (iconName) {
        "phone" -> Icons.Default.Phone
        "settings" -> Icons.Default.Settings
        "favorite" -> Icons.Default.Favorite
        "lock" -> Icons.Default.Lock
        "add" -> Icons.Default.Add
        "star" -> Icons.Default.Star
        else -> Icons.Default.Star
    }

    return Feature(
        id = id,
        title = title,
        description = description,
        icon = icon,
        category = category,
        isEnabled = isEnabled,
        priority = priority
    )
}

fun ShowcaseResponse.toDomain(): ShowcaseItem {
    return ShowcaseItem(
        id = id,
        title = title,
        subtitle = subtitle,
        description = description,
        imageUrl = imageUrl
    )
}

fun StatsResponse.toDomain(): Stats {
    return Stats(
        uptime = uptime,
        supportHours = supportHours,
        userCount = userCount,
        lastUpdated = lastUpdated
    )
}