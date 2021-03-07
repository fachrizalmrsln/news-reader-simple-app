package com.fachrizalmrsln.newsreadersimple.di

import com.fachrizalmrsln.component.base.navigation.IAppNavigation
import com.fachrizalmrsln.component.base.network.createApi
import com.fachrizalmrsln.features.news_data.api.INewsAPI
import com.fachrizalmrsln.newsreadersimple.navigation.AppNavigation
import org.koin.dsl.module

val appModule = module {
    single<IAppNavigation> { AppNavigation() }
    single { createApi<INewsAPI>(get()) }
}