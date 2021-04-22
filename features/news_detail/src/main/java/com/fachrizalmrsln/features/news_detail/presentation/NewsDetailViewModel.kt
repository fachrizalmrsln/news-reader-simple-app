package com.fachrizalmrsln.features.news_detail.presentation

import androidx.lifecycle.LiveData
import com.fachrizalmrsln.component.base.database.NewsListEntity
import com.fachrizalmrsln.component.base.viewmodel.BaseViewModel
import com.fachrizalmrsln.features.news_detail.repository.NewsDetailCatalogueRepository

class NewsDetailViewModel(
    private val repository: NewsDetailCatalogueRepository
) : BaseViewModel() {

    fun bookmarkingData(dataBookmark: NewsListEntity) {
        repository.bookmarkingData(dataBookmark)
    }

    fun getDataBookmarkDetail(dataID: Int): LiveData<NewsListEntity> {
        return repository.getDataBookmarkDetail(dataID)
    }

    fun unBookmarkingData(dataBookmark: NewsListEntity) {
        repository.unBookmarkingData(dataBookmark)
    }

}