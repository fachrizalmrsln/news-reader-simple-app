package com.fachrizalmrsln.features.news_detail.repository.local

import androidx.lifecycle.LiveData
import com.fachrizalmrsln.component.base.database.NewsListEntity

interface INewsDetailLocalRepository {

    fun bookmarkingData(dataBookmark: NewsListEntity)

    fun unBookmarkingData(dataBookmark: NewsListEntity)

    fun getDataBookmarkDetail(dataID: Int): LiveData<NewsListEntity>
    
}