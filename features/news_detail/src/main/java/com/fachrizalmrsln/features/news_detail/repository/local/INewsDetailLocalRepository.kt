package com.fachrizalmrsln.features.news_detail.repository.local

import androidx.lifecycle.LiveData
import com.fachrizalmrsln.features.news_list.database.NewsListBookmarkEntity

interface INewsDetailLocalRepository {

    fun bookmarkingData(dataBookmark: NewsListBookmarkEntity)

    fun unBookmarkingData(dataBookmark: NewsListBookmarkEntity)

    fun getDataBookmarkDetail(dataID: Int): LiveData<NewsListBookmarkEntity>
    
}