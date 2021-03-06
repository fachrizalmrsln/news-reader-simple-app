package com.fachrizalmrsln.newsreadersimple.di

import com.fachrizalmrsln.component.base.navigation.IAppNavigation
import com.fachrizalmrsln.component.base.network.createApi
import com.fachrizalmrsln.features.news_data.api.INewsAPI
import com.fachrizalmrsln.newsreadersimple.database.NewsAppDatabase
import com.fachrizalmrsln.newsreadersimple.navigation.AppNavigation
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    single { NewsAppDatabase.getDatabase(androidContext()).newsDao() }
    single<IAppNavigation> { AppNavigation() }
    single { createApi<INewsAPI>(get()) }
}