package com.verkada.android.catpictures.ui.uistate

import androidx.paging.PagingData
import com.verkada.android.catpictures.data.model.Picture
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class HomeUiState(
    val selectedPicture: Picture? = null,
    val favoritePictures: Set<Picture> = emptySet(),
    val picturePagingData: StateFlow<PagingData<Picture>> = MutableStateFlow(PagingData.empty()),
)
