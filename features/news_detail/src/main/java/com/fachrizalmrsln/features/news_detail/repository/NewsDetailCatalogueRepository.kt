package com.fachrizalmrsln.features.news_detail.repository

import androidx.lifecycle.LiveData
import com.fachrizalmrsln.component.base.database.NewsListEntity
import com.fachrizalmrsln.features.news_detail.repository.local.INewsDetailLocalRepository

class NewsDetailCatalogueRepository(
    private val newsLocalRepository: INewsDetailLocalRepository,
) : INewsDetailLocalRepository {

    override fun bookmarkingData(dataBookmark: NewsListEntity) {
        newsLocalRepository.bookmarkingData(dataBookmark)
    }

    override fun unBookmarkingData(dataBookmark: NewsListEntity) {
        return newsLocalRepository.unBookmarkingData(dataBookmark)
    }

    override fun getDataBookmarkDetail(dataID: Int): LiveData<NewsListEntity> {
        return newsLocalRepository.getDataBookmarkDetail(dataID)
    }

}