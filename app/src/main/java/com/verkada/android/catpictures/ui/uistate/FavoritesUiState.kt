package com.verkada.android.catpictures.ui.uistate

import com.verkada.android.catpictures.data.model.Picture

data class FavoritesUiState(
    val selectedPicture: Picture? = null,
    val favoritePictures: Set<Picture> = emptySet(),
)
