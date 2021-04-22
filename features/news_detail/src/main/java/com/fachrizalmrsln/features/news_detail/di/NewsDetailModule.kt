package com.fachrizalmrsln.features.news_detail.di

import com.fachrizalmrsln.features.news_detail.presentation.NewsDetailViewModel
import com.fachrizalmrsln.features.news_detail.repository.NewsDetailCatalogueRepository
import com.fachrizalmrsln.features.news_detail.repository.local.INewsDetailLocalRepository
import com.fachrizalmrsln.features.news_detail.repository.local.NewsDetailLocalRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val newsDetailModule = module {
    single<INewsDetailLocalRepository> { NewsDetailLocalRepository(get()) }
    single { NewsDetailCatalogueRepository(get()) }
    viewModel { NewsDetailViewModel(get()) }
}
