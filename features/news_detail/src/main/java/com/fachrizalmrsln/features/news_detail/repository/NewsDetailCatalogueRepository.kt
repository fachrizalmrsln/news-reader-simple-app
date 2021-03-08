package com.fachrizalmrsln.features.news_detail.repository

import androidx.lifecycle.LiveData
import com.fachrizalmrsln.component.base.database.NewsBookmarkEntity
import com.fachrizalmrsln.features.news_detail.repository.local.INewsDetailLocalRepository

class NewsDetailCatalogueRepository(
    private val newsLocalRepository: INewsDetailLocalRepository,
) : INewsDetailLocalRepository {

    override fun bookmarkingData(dataBookmark: NewsBookmarkEntity) {
        newsLocalRepository.bookmarkingData(dataBookmark)
    }

    override fun unBookmarkingData(dataBookmark: NewsBookmarkEntity) {
        return newsLocalRepository.unBookmarkingData(dataBookmark)
    }

    override fun getDataBookmarkDetail(dataID: Int): LiveData<NewsBookmarkEntity> {
        return newsLocalRepository.getDataBookmarkDetail(dataID)
    }

}