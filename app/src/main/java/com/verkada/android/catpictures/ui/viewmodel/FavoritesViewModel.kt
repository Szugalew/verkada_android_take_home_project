package com.verkada.android.catpictures.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.verkada.android.catpictures.data.model.Picture
import com.verkada.android.catpictures.data.repository.FavoritesRepository
import com.verkada.android.catpictures.ui.uistate.FavoritesUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class FavoritesViewModel(
    private val favoritesRepository: FavoritesRepository = FavoritesRepository(),
) : ViewModel() {

    private val _uiState: MutableStateFlow<FavoritesUiState> = MutableStateFlow(FavoritesUiState())
    val uiState: StateFlow<FavoritesUiState> = _uiState

    init {
        getFavorites()
    }

    private fun getFavorites() {
        viewModelScope.launch {
            favoritesRepository.favorites
                .collect { favoritePictures ->
                    _uiState.value = _uiState.value.copy(
                        selectedPicture = _uiState.value.selectedPicture.takeIf {
                            favoritePictures.contains(it)
                        },
                        favoritePictures = favoritePictures,
                    )
                }
        }
    }

    fun selectPicture(picture: Picture) {
        _uiState.value = _uiState.value.copy(
            selectedPicture = picture.takeIf { it != _uiState.value.selectedPicture }
        )
    }

    fun unFavorite(picture: Picture) {
        favoritesRepository.toggleFavorite(picture)
    }
}
