package com.verkada.android.catpictures.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.verkada.android.catpictures.data.model.Picture
import com.verkada.android.catpictures.data.source.RemoteImagePagingSource
import com.verkada.android.catpictures.network.PictureService
import kotlinx.coroutines.flow.Flow

class ImageRepository {
    val pictures: Flow<PagingData<Picture>> = Pager(
        config = PagingConfig(pageSize = PictureService.PER_PAGE_COUNT, prefetchDistance = 2),
        pagingSourceFactory = {
            RemoteImagePagingSource()
        }
    ).flow
}
