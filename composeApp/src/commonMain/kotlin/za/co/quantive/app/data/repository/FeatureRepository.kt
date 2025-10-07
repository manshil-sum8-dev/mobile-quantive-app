package za.co.quantive.app.data.repository

import za.co.quantive.app.data.datasource.RemoteDataSource
import za.co.quantive.app.data.model.*

interface FeatureRepository {
    suspend fun getFeatures(): Result<List<Feature>>
    suspend fun getShowcaseItems(): Result<List<ShowcaseItem>>
    suspend fun getStats(): Result<Stats>
    suspend fun getFeatureById(id: String): Result<Feature?>
}

class FeatureRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
) : FeatureRepository {

    override suspend fun getFeatures(): Result<List<Feature>> {
        return try {
            val response = remoteDataSource.getFeatures()
            response.map { features ->
                features
                    .filter { it.isEnabled }
                    .sortedBy { it.priority }
                    .map { it.toDomain() }
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getShowcaseItems(): Result<List<ShowcaseItem>> {
        return try {
            val response = remoteDataSource.getShowcaseItems()
            response.map { showcaseItems ->
                showcaseItems.map { it.toDomain() }
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getStats(): Result<Stats> {
        return try {
            val response = remoteDataSource.getStats()
            response.map { it.toDomain() }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getFeatureById(id: String): Result<Feature?> {
        return try {
            val features = getFeatures().getOrNull()
            val feature = features?.find { it.id == id }
            Result.success(feature)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}