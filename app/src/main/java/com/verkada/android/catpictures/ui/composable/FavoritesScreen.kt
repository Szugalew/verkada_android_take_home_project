package com.verkada.android.catpictures.ui.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.unit.dp
import com.verkada.android.catpictures.ui.viewmodel.FavoritesViewModel

@Composable
fun FavoritesScreen(viewModel: FavoritesViewModel) {
    val uiState = viewModel.uiState.collectAsState()

    Column {
        ImagePreview(
            pictureUrl = uiState.value.selectedPicture?.url,
            isFavorite = uiState.value.favoritePictures.contains(uiState.value.selectedPicture),
            onFavoriteToggled = {
                uiState.value.selectedPicture?.let {
                    viewModel.unFavorite(it)
                }
            },
        )
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 128.dp),
            contentPadding = PaddingValues(2.dp),
        ) {
            items(uiState.value.favoritePictures.toList()) { picture ->
                GridImage(
                    pictureUrl = picture.url,
                    onPictureClick = { viewModel.selectPicture(picture) },
                )
            }
        }
    }
}
