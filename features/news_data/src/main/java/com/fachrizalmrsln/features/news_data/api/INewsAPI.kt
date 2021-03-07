package com.fachrizalmrsln.features.news_data.api

import com.fachrizalmrsln.features.news_data.response.NewsListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface INewsAPI {

    @GET("listapi.json")
    suspend fun getNewsList(
        @Query ("pageNumber") pageNumber: Int
    ): NewsListResponse

}