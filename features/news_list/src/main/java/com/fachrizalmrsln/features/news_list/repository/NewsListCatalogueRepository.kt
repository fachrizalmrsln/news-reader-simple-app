package com.fachrizalmrsln.features.news_list.repository

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.fachrizalmrsln.component.base.database.NewsBookmarkEntity
import com.fachrizalmrsln.component.network.NetworkResult
import com.fachrizalmrsln.features.news_data.response.NewsListResponse
import com.fachrizalmrsln.features.news_list.repository.local.INewsListLocalRepository
import com.fachrizalmrsln.features.news_list.repository.remote.INewsListRemoteRepository

class NewsListCatalogueRepository(
    private val newsListRemoteRepository: INewsListRemoteRepository,
    private val newsListLocalRepository: INewsListLocalRepository,
) : INewsListRemoteRepository, INewsListLocalRepository {

    override suspend fun getNewsList(pageNumber: Int): NetworkResult<NewsListResponse> {
        return newsListRemoteRepository.getNewsList(pageNumber)
    }

    override fun bookmarkingData(dataBookmark: NewsBookmarkEntity) {
        newsListLocalRepository.bookmarkingData(dataBookmark)
    }

    override fun getDataBookmark(): LiveData<PagedList<NewsBookmarkEntity>> {
        return newsListLocalRepository.getDataBookmark()
    }

    override fun unBookmarkingData(dataBookmark: NewsBookmarkEntity) {
        return newsListLocalRepository.unBookmarkingData(dataBookmark)
    }

}