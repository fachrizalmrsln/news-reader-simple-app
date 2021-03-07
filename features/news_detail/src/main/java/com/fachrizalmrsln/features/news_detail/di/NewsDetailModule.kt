package com.fachrizalmrsln.features.news_detail.di

import com.fachrizalmrsln.features.news_detail.presenter.NewsDetailViewModel
import com.fachrizalmrsln.features.news_detail.repository.NewsDetailCatalogueRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val newsDetailModule = module {
    single { NewsDetailCatalogueRepository(get()) }
    viewModel { NewsDetailViewModel(get()) }
}
