package com.fachrizalmrsln.features.news_list.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
import com.fachrizalmrsln.component.base.database.NewsBookmarkEntity
import com.fachrizalmrsln.component.base.viewmodel.BaseViewModel
import com.fachrizalmrsln.component.base.viewmodel.Message
import com.fachrizalmrsln.features.news_data.response.NewsListResponse
import com.fachrizalmrsln.features.news_list.repository.NewsListCatalogueRepository

class NewsListViewModel(
    private val repository: NewsListCatalogueRepository
) : BaseViewModel() {

    private val _newsListResponse = MutableLiveData<NewsListResponse>()
    val newsListResponse: LiveData<NewsListResponse>
        get() = _newsListResponse

    suspend fun getNewsList(pageNumber: Int) {
        showLoading()
        repository.getNewsList(pageNumber).onResultShow({ newsListResponse ->
            if (newsListResponse != null) {
                _newsListResponse.value = newsListResponse
                hideLoading()
            }
        }, { exception ->
            _message.value = Message.Dialog(exception.message)
            hideLoading()
        })
    }

    fun bookmarkingData(dataBookmark: NewsBookmarkEntity) {
        repository.bookmarkingData(dataBookmark)
    }

    fun getDataBookmarkList(): LiveData<PagedList<NewsBookmarkEntity>> {
        return repository.getDataBookmark()
    }

    fun unBookmarkingData(dataBookmark: NewsBookmarkEntity) {
        repository.unBookmarkingData(dataBookmark)
    }

}