package za.co.quantive.app.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import za.co.quantive.app.data.model.Feature
import za.co.quantive.app.data.model.ShowcaseItem
import za.co.quantive.app.data.model.Stats
import za.co.quantive.app.data.repository.FeatureRepository

data class HomeUiState(
    val isLoading: Boolean = false,
    val features: List<Feature> = emptyList(),
    val showcaseItems: List<ShowcaseItem> = emptyList(),
    val stats: Stats? = null,
    val selectedFeature: Feature? = null,
    val isHeaderVisible: Boolean = true,
    val error: String? = null
)

class HomeViewModel(
    private val featureRepository: FeatureRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, error = null)

            try {
                // Load features
                val featuresResult = featureRepository.getFeatures()
                val showcaseItemsResult = featureRepository.getShowcaseItems()
                val statsResult = featureRepository.getStats()

                val features = featuresResult.getOrNull() ?: emptyList()
                val showcaseItems = showcaseItemsResult.getOrNull() ?: emptyList()
                val stats = statsResult.getOrNull()

                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    features = features,
                    showcaseItems = showcaseItems,
                    stats = stats,
                    error = if (featuresResult.isFailure || showcaseItemsResult.isFailure || statsResult.isFailure) {
                        "Failed to load some data"
                    } else null
                )
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    error = e.message
                )
            }
        }
    }

    fun onFeatureClick(feature: Feature) {
        _uiState.value = _uiState.value.copy(
            selectedFeature = if (_uiState.value.selectedFeature == feature) null else feature
        )
    }

    fun onExploreClick() {
        _uiState.value = _uiState.value.copy(
            isHeaderVisible = !_uiState.value.isHeaderVisible
        )
    }

    fun clearError() {
        _uiState.value = _uiState.value.copy(error = null)
    }

    fun refresh() {
        loadData()
    }
}