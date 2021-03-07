package com.fachrizalmrsln.features.news_list.repository.remote

import com.fachrizalmrsln.component.network.NetworkResult
import com.fachrizalmrsln.features.news_data.response.NewsListResponse

interface INewsListRemoteRepository {

    suspend fun getNewsList(pageNumber: Int): NetworkResult<NewsListResponse>

}