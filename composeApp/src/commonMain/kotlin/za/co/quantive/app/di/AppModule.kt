package za.co.quantive.app.di

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module
import za.co.quantive.app.data.repository.FeatureRepository
import za.co.quantive.app.data.repository.FeatureRepositoryImpl

val appModule = module {

    
  
    // Network Module
    single {
        HttpClient {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    isLenient = true
                })
            }
            install(Logging) {
                level = LogLevel.INFO
            }
        }
    }

    // Repository Module
    single<FeatureRepository> { FeatureRepositoryImpl(get()) }
}