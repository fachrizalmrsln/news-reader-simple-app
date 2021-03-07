package com.fachrizalmrsln.features.news_list.repository.remote

import com.fachrizalmrsln.component.base.network.NetworkStateManager
import com.fachrizalmrsln.component.base.repository.BaseRepository
import com.fachrizalmrsln.component.network.NetworkResult
import com.fachrizalmrsln.features.news_data.api.INewsAPI
import com.fachrizalmrsln.features.news_data.response.NewsListResponse
import com.fachrizalmrsln.features.news_list.database.NewsListBookmarkEntity

class NewsListRemoteRepository(
    private val newsAPI: INewsAPI,
    networkStateManager: NetworkStateManager
): BaseRepository(networkStateManager), INewsListRemoteRepository {

    override suspend fun getNewsList(pageNumber: Int): NetworkResult<NewsListResponse> {
        return checkInternetAndAwaitResult { newsAPI.getNewsList(pageNumber) }
    }

}