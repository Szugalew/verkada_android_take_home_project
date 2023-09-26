package com.verkada.android.catpictures.data.repository

import com.verkada.android.catpictures.data.model.Picture
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class FavoritesRepository {

    val favorites: Flow<Set<Picture>> = _favorites

    fun toggleFavorite(picture: Picture) {
        _favorites.value = if (_favorites.value.contains(picture)) {
            _favorites.value.minus(picture)
        } else {
            _favorites.value.plus(picture)
        }
    }

    companion object {
        // Static variable to store favorites
        // In larger projects favorites could be saved in a local database or on the server
        private val _favorites: MutableStateFlow<Set<Picture>> = MutableStateFlow(emptySet())
    }
}
