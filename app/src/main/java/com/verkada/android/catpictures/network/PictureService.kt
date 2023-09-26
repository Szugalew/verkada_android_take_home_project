package com.verkada.android.catpictures.network

import com.verkada.android.catpictures.data.model.Picture
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface PictureService {

    @GET("list")
    suspend fun getPictures(
        @Query("page") page: Int = 1,
        @Query("limit") perPage: Int = PER_PAGE_COUNT,
    ): List<Picture>

    companion object {
        const val PER_PAGE_COUNT = 30
        private const val ROOT_URL = "https://picsum.photos/v2/"

        fun createPictureService(): PictureService = Retrofit.Builder()
            .baseUrl(ROOT_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PictureService::class.java)
    }
}
