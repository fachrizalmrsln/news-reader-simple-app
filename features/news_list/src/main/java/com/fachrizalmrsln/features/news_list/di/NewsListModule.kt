package com.fachrizalmrsln.features.news_list.di

import com.fachrizalmrsln.features.news_list.database.NewsListDatabase
import com.fachrizalmrsln.features.news_list.presenter.NewsListViewModel
import com.fachrizalmrsln.features.news_list.repository.NewsListCatalogueRepository
import com.fachrizalmrsln.features.news_list.repository.local.INewsListLocalRepository
import com.fachrizalmrsln.features.news_list.repository.local.NewsListLocalRepository
import com.fachrizalmrsln.features.news_list.repository.remote.INewsListRemoteRepository
import com.fachrizalmrsln.features.news_list.repository.remote.NewsListRemoteRepository
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val newsListModule = module {
    single<INewsListLocalRepository> {
        NewsListLocalRepository(
            NewsListDatabase.getDatabase(androidContext()).newsListDao()
        )
    }
    single<INewsListRemoteRepository> { NewsListRemoteRepository(get(), get()) }
    single { NewsListCatalogueRepository(get(), get()) }
    viewModel { NewsListViewModel(get()) }
}
