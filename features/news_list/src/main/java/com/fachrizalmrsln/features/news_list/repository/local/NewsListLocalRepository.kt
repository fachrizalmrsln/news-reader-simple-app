package com.fachrizalmrsln.features.news_list.repository.local

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.fachrizalmrsln.features.news_list.database.NewsListBookmarkEntity
import com.fachrizalmrsln.features.news_list.database.NewsListDAO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class NewsListLocalRepository(
    private val newsListDAO: NewsListDAO
): INewsListLocalRepository {

    override fun bookmarkingData(dataBookmark: NewsListBookmarkEntity) {
        GlobalScope.launch(Dispatchers.IO) {
            newsListDAO.bookmarkingData(dataBookmark)
        }
    }

    override fun getDataBookmark(): LiveData<PagedList<NewsListBookmarkEntity>> {
        return LivePagedListBuilder(newsListDAO.getDataBookmark(), 10).build()
    }

    override fun unBookmarkingData(dataBookmark: NewsListBookmarkEntity) {
        GlobalScope.launch(Dispatchers.IO) {
            newsListDAO.unBookmarkingData(dataBookmark)
        }
    }

    override fun getDataBookmarkDetail(dataID: Int): LiveData<NewsListBookmarkEntity> {
        return newsListDAO.getDataBookmarkDetail(dataID)
    }

}