package com.verkada.android.catpictures.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.verkada.android.catpictures.data.model.Picture
import com.verkada.android.catpictures.data.repository.FavoritesRepository
import com.verkada.android.catpictures.data.repository.ImageRepository
import com.verkada.android.catpictures.ui.uistate.HomeUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val imageRepository: ImageRepository = ImageRepository(),
    private val favoritesRepository: FavoritesRepository = FavoritesRepository(),
) : ViewModel() {

    private val _uiState: MutableStateFlow<HomeUiState> = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState

    init {
        getPictures()
        getFavorites()
    }

    private fun getFavorites() {
        viewModelScope.launch {
            favoritesRepository.favorites
                .collect {
                    _uiState.value = _uiState.value.copy(favoritePictures = it)
                }
        }
    }

    private fun getPictures() {
        viewModelScope.launch {
            imageRepository.pictures
                .cachedIn(viewModelScope)
                .collect {
                    _uiState.value = _uiState.value.copy(picturePagingData = MutableStateFlow(it))
                }
        }
    }

    fun selectPicture(picture: Picture?) {
        _uiState.value = _uiState.value.copy(
            selectedPicture = picture.takeIf { it != _uiState.value.selectedPicture }
        )
    }

    fun toggleFavorite(picture: Picture) {
        favoritesRepository.toggleFavorite(picture)
    }
}
