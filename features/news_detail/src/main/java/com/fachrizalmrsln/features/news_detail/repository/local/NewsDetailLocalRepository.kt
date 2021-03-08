package com.fachrizalmrsln.features.news_detail.repository.local

import androidx.lifecycle.LiveData
import com.fachrizalmrsln.component.base.database.NewsDAO
import com.fachrizalmrsln.component.base.database.NewsListEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class NewsDetailLocalRepository(
    private val newsDao: NewsDAO
): INewsDetailLocalRepository {

    override fun bookmarkingData(dataBookmark: NewsListEntity) {
        GlobalScope.launch(Dispatchers.IO) {
            newsDao.bookmarkingData(dataBookmark)
        }
    }

    override fun unBookmarkingData(dataBookmark: NewsListEntity) {
        GlobalScope.launch(Dispatchers.IO) {
            newsDao.unBookmarkingData(dataBookmark)
        }
    }

    override fun getDataBookmarkDetail(dataID: Int): LiveData<NewsListEntity> {
        return newsDao.getDataBookmarkDetail(dataID)
    }

}