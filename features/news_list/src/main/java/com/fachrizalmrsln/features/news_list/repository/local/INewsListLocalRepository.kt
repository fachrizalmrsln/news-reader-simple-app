package com.fachrizalmrsln.features.news_list.repository.local

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.fachrizalmrsln.component.base.database.NewsListEntity

interface INewsListLocalRepository {

    fun insertNewsListToDB(dataNewsList: List<NewsListEntity>)

    fun getNewsList(): LiveData<PagedList<NewsListEntity>>

    fun bookmarkingData(dataBookmark: NewsListEntity)

    fun getDataBookmark(): LiveData<PagedList<NewsListEntity>>

    fun unBookmarkingData(dataBookmark: NewsListEntity)

}