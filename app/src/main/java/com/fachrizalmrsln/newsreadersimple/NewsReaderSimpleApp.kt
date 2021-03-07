package com.fachrizalmrsln.newsreadersimple

import android.app.Application
import com.fachrizalmrsln.component.base.BuildConfig
import com.fachrizalmrsln.component.base.di.baseNetwork
import com.fachrizalmrsln.features.news_detail.di.newsDetailModule
import com.fachrizalmrsln.features.news_list.di.newsListModule
import com.fachrizalmrsln.newsreadersimple.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber

class NewsReaderSimpleApp : Application() {

    override fun onCreate() {
        super.onCreate()
        setupTimber()
        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            if (BuildConfig.DEBUG) {
                androidLogger(Level.INFO)
            }
            androidContext(this@NewsReaderSimpleApp)
            modules(
                listOf(baseNetwork) +
                        listOf(appModule) +
                        listOf(newsListModule) +
                        listOf(newsDetailModule)
            )
        }
    }

    private fun setupTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

}