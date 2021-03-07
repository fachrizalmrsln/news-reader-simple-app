package com.fachrizalmrsln.features.news_list.repository

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.fachrizalmrsln.component.network.NetworkResult
import com.fachrizalmrsln.features.news_data.response.NewsListResponse
import com.fachrizalmrsln.features.news_list.database.NewsListBookmarkEntity
import com.fachrizalmrsln.features.news_list.repository.local.INewsListLocalRepository
import com.fachrizalmrsln.features.news_list.repository.remote.INewsListRemoteRepository

class NewsListCatalogueRepository(
    private val newsListRemoteRepository: INewsListRemoteRepository,
    private val newsListLocalRepository: INewsListLocalRepository,
) : INewsListRemoteRepository, INewsListLocalRepository {

    override suspend fun getNewsList(pageNumber: Int): NetworkResult<NewsListResponse> {
        return newsListRemoteRepository.getNewsList(pageNumber)
    }

    override fun bookmarkingData(dataBookmark: NewsListBookmarkEntity) {
        newsListLocalRepository.bookmarkingData(dataBookmark)
    }

    override fun getDataBookmark(): LiveData<PagedList<NewsListBookmarkEntity>> {
        return newsListLocalRepository.getDataBookmark()
    }

    override fun unBookmarkingData(dataBookmark: NewsListBookmarkEntity) {
        return newsListLocalRepository.unBookmarkingData(dataBookmark)
    }

    override fun getDataBookmarkDetail(dataID: Int): LiveData<NewsListBookmarkEntity> {
        return newsListLocalRepository.getDataBookmarkDetail(dataID)
    }

}