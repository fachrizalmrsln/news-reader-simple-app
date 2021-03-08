package com.fachrizalmrsln.features.news_list.repository.local

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.fachrizalmrsln.component.base.database.NewsDAO
import com.fachrizalmrsln.component.base.database.NewsListEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class NewsListLocalRepository(
    private val newsDao: NewsDAO
) : INewsListLocalRepository {

    override fun insertNewsListToDB(dataNewsList: List<NewsListEntity>) {
        GlobalScope.launch(Dispatchers.IO) {
            newsDao.insertNewsListToDB(dataNewsList)
        }
    }

    override fun getNewsList(): LiveData<PagedList<NewsListEntity>> {
        val pagedListConfig = PagedList.Config.Builder()
            .setEnablePlaceholders(true)
            .setPageSize(110).build()
        return LivePagedListBuilder(newsDao.getNewsList(), pagedListConfig).build()
    }

    override fun bookmarkingData(dataBookmark: NewsListEntity) {
        GlobalScope.launch(Dispatchers.IO) {
            newsDao.bookmarkingData(dataBookmark)
        }
    }

    override fun getDataBookmark(): LiveData<PagedList<NewsListEntity>> {
        return LivePagedListBuilder(newsDao.getDataBookmark(), 10).build()
    }

    override fun unBookmarkingData(dataBookmark: NewsListEntity) {
        GlobalScope.launch(Dispatchers.IO) {
            newsDao.unBookmarkingData(dataBookmark)
        }
    }

}