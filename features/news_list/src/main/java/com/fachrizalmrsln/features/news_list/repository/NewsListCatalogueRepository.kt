package com.fachrizalmrsln.features.news_list.repository

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.fachrizalmrsln.component.base.database.NewsListEntity
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

    override fun insertNewsListToDB(dataNewsList: List<NewsListEntity>) {
        return newsListLocalRepository.insertNewsListToDB(dataNewsList)
    }

    override fun getNewsList(): LiveData<PagedList<NewsListEntity>> {
        return newsListLocalRepository.getNewsList()
    }

    override fun bookmarkingData(dataBookmark: NewsListEntity) {
        newsListLocalRepository.bookmarkingData(dataBookmark)
    }

    override fun getDataBookmark(): LiveData<PagedList<NewsListEntity>> {
        return newsListLocalRepository.getDataBookmark()
    }

    override fun unBookmarkingData(dataBookmark: NewsListEntity) {
        return newsListLocalRepository.unBookmarkingData(dataBookmark)
    }

}