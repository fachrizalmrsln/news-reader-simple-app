package com.fachrizalmrsln.features.news_detail.presenter

import androidx.lifecycle.LiveData
import com.fachrizalmrsln.component.base.viewmodel.BaseViewModel
import com.fachrizalmrsln.features.news_detail.repository.NewsDetailCatalogueRepository
import com.fachrizalmrsln.features.news_list.database.NewsListBookmarkEntity

class NewsDetailViewModel(
    private val repository: NewsDetailCatalogueRepository
) : BaseViewModel() {

    fun bookmarkingData(dataBookmark: NewsListBookmarkEntity) {
        repository.bookmarkingData(dataBookmark)
    }

    fun getDataBookmarkDetail(dataID: Int): LiveData<NewsListBookmarkEntity> {
        return repository.getDataBookmarkDetail(dataID)
    }

    fun unBookmarkingData(dataBookmark: NewsListBookmarkEntity) {
        repository.unBookmarkingData(dataBookmark)
    }

}