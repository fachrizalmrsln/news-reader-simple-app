package com.fachrizalmrsln.features.news_list.presenter

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.fachrizalmrsln.component.base.database.NewsListEntity
import com.fachrizalmrsln.component.base.viewmodel.BaseViewModel
import com.fachrizalmrsln.component.base.viewmodel.Message
import com.fachrizalmrsln.features.news_data.response.Row
import com.fachrizalmrsln.features.news_list.repository.NewsListCatalogueRepository

class NewsListViewModel(
    private val repository: NewsListCatalogueRepository
) : BaseViewModel() {

    val newsListResponse = repository.getNewsList()

    suspend fun getNewsList(pageNumber: Int) {
        showLoading()
        repository.getNewsList(pageNumber).onResultShow({ newsListResponse ->
            if (newsListResponse != null) {
                insertToDB(newsListResponse.data.rows)
                hideLoading()
            }
        }, { exception ->
            _message.value = Message.Dialog(exception.message)
            hideLoading()
        })
    }

    fun bookmarkingData(dataBookmark: NewsListEntity) {
        repository.bookmarkingData(dataBookmark)
    }

    fun getDataBookmarkList(): LiveData<PagedList<NewsListEntity>> {
        return repository.getDataBookmark()
    }

    fun unBookmarkingData(dataBookmark: NewsListEntity) {
        repository.unBookmarkingData(dataBookmark)
    }

    private fun insertToDB(data: List<Row>) {
        val dataToDB = mutableListOf<NewsListEntity>()
        data.map {
            dataToDB.add(
                NewsListEntity(
                    id = it.id,
                    title = it.title,
                    description = it.description,
                    category = it.category,
                    detailUrl = it.detailUrl,
                    publishTime = it.publishTime,
                    coverPic = it.coverPic?.get(0)
                )
            )
        }
        repository.insertNewsListToDB(dataToDB)
    }

}