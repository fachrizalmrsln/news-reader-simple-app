package com.fachrizalmrsln.features.news_list.repository.local

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.fachrizalmrsln.features.news_list.database.NewsListBookmarkEntity

interface INewsListLocalRepository {

    fun bookmarkingData(dataBookmark: NewsListBookmarkEntity)

    fun getDataBookmark(): LiveData<PagedList<NewsListBookmarkEntity>>

    fun unBookmarkingData(dataBookmark: NewsListBookmarkEntity)

    fun getDataBookmarkDetail(dataID: Int): LiveData<NewsListBookmarkEntity>

}