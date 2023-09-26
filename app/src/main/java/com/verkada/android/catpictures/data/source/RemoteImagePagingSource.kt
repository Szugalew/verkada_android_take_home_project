package com.verkada.android.catpictures.data.source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.verkada.android.catpictures.data.model.Picture
import com.verkada.android.catpictures.network.PictureService

class RemoteImagePagingSource(
    private val pictureService: PictureService = PictureService.createPictureService(),
) : PagingSource<Int, Picture>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Picture> {
        val currentPage = params.key ?: 1
        val pictures = pictureService.getPictures(
            page = currentPage,
            perPage = params.loadSize,
        )
        return LoadResult.Page(
            data = pictures,
            prevKey = if (currentPage == 1) null else currentPage - 1,
            nextKey = if (pictures.isEmpty()) null else currentPage + 1
        )
    }

    override fun getRefreshKey(state: PagingState<Int, Picture>): Int? = null
}
