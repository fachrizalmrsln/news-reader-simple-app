package com.fachrizalmrsln.features.news_list.repository.local

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.fachrizalmrsln.component.base.database.NewsBookmarkEntity
import com.fachrizalmrsln.component.base.database.NewsDAO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class NewsListLocalRepository(
    private val newsDao: NewsDAO
): INewsListLocalRepository {

    override fun bookmarkingData(dataBookmark: NewsBookmarkEntity) {
        GlobalScope.launch(Dispatchers.IO) {
            newsDao.bookmarkingData(dataBookmark)
        }
    }

    override fun getDataBookmark(): LiveData<PagedList<NewsBookmarkEntity>> {
        return LivePagedListBuilder(newsDao.getDataBookmark(), 10).build()
    }

    override fun unBookmarkingData(dataBookmark: NewsBookmarkEntity) {
        GlobalScope.launch(Dispatchers.IO) {
            newsDao.unBookmarkingData(dataBookmark)
        }
    }

}