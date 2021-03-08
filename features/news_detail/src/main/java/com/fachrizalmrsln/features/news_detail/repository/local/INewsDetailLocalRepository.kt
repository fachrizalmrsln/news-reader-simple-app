package com.fachrizalmrsln.features.news_detail.repository.local

import androidx.lifecycle.LiveData
import com.fachrizalmrsln.component.base.database.NewsBookmarkEntity

interface INewsDetailLocalRepository {

    fun bookmarkingData(dataBookmark: NewsBookmarkEntity)

    fun unBookmarkingData(dataBookmark: NewsBookmarkEntity)

    fun getDataBookmarkDetail(dataID: Int): LiveData<NewsBookmarkEntity>
    
}