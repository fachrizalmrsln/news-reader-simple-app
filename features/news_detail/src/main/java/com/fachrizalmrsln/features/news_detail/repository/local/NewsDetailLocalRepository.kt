package com.fachrizalmrsln.features.news_detail.repository.local

import androidx.lifecycle.LiveData
import com.fachrizalmrsln.component.base.database.NewsBookmarkEntity
import com.fachrizalmrsln.component.base.database.NewsDAO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class NewsDetailLocalRepository(
    private val newsDao: NewsDAO
): INewsDetailLocalRepository {

    override fun bookmarkingData(dataBookmark: NewsBookmarkEntity) {
        GlobalScope.launch(Dispatchers.IO) {
            newsDao.bookmarkingData(dataBookmark)
        }
    }

    override fun unBookmarkingData(dataBookmark: NewsBookmarkEntity) {
        GlobalScope.launch(Dispatchers.IO) {
            newsDao.unBookmarkingData(dataBookmark)
        }
    }

    override fun getDataBookmarkDetail(dataID: Int): LiveData<NewsBookmarkEntity> {
        return newsDao.getDataBookmarkDetail(dataID)
    }

}