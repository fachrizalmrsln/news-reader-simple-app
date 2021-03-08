package com.fachrizalmrsln.features.news_list.repository.local

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.fachrizalmrsln.component.base.database.NewsBookmarkEntity

interface INewsListLocalRepository {

    fun bookmarkingData(dataBookmark: NewsBookmarkEntity)

    fun getDataBookmark(): LiveData<PagedList<NewsBookmarkEntity>>

    fun unBookmarkingData(dataBookmark: NewsBookmarkEntity)

}