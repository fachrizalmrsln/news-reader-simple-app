package com.fachrizalmrsln.features.news_detail.presenter

import androidx.lifecycle.LiveData
import com.fachrizalmrsln.component.base.database.NewsBookmarkEntity
import com.fachrizalmrsln.component.base.viewmodel.BaseViewModel
import com.fachrizalmrsln.features.news_detail.repository.NewsDetailCatalogueRepository

class NewsDetailViewModel(
    private val repository: NewsDetailCatalogueRepository
) : BaseViewModel() {

    fun bookmarkingData(dataBookmark: NewsBookmarkEntity) {
        repository.bookmarkingData(dataBookmark)
    }

    fun getDataBookmarkDetail(dataID: Int): LiveData<NewsBookmarkEntity> {
        return repository.getDataBookmarkDetail(dataID)
    }

    fun unBookmarkingData(dataBookmark: NewsBookmarkEntity) {
        repository.unBookmarkingData(dataBookmark)
    }

}