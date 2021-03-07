package com.fachrizalmrsln.features.news_detail.repository

import androidx.lifecycle.LiveData
import com.fachrizalmrsln.features.news_detail.repository.local.INewsDetailLocalRepository
import com.fachrizalmrsln.features.news_list.database.NewsListBookmarkEntity
import com.fachrizalmrsln.features.news_list.repository.local.INewsListLocalRepository

class NewsDetailCatalogueRepository(
    private val newsListLocalRepository: INewsListLocalRepository,
) : INewsDetailLocalRepository {

    override fun bookmarkingData(dataBookmark: NewsListBookmarkEntity) {
        newsListLocalRepository.bookmarkingData(dataBookmark)
    }

    override fun unBookmarkingData(dataBookmark: NewsListBookmarkEntity) {
        return newsListLocalRepository.unBookmarkingData(dataBookmark)
    }

    override fun getDataBookmarkDetail(dataID: Int): LiveData<NewsListBookmarkEntity> {
        return newsListLocalRepository.getDataBookmarkDetail(dataID)
    }

}