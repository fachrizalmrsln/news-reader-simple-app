package com.fachrizalmrsln.newsreadersimple.navigation

import android.content.Context
import com.fachrizalmrsln.component.base.navigation.IAppNavigation
import com.fachrizalmrsln.features.news_detail.presentation.NewsDetailActivity
import com.fachrizalmrsln.features.news_list.presentation.NewsListActivity
import splitties.activities.start

class AppNavigation : IAppNavigation {

    override fun navigateToNewsList(context: Context) = context.start<NewsListActivity>()

    override fun navigateToNewsDetail(
        context: Context,
        dataID: Int,
        dataDetail: String,
        dataCategory: String,
        dataCoverPic: String?,
        dataPublishTime: Int,
        dataTitle: String,
        dataDescription: String
    ) =
        context.start<NewsDetailActivity> {
            putExtra(NewsDetailActivity.DATA_ID, dataID)
            putExtra(NewsDetailActivity.DATA_DETAIL, dataDetail)
            putExtra(NewsDetailActivity.DATA_CATEGORY, dataCategory)
            putExtra(NewsDetailActivity.DATA_COVER_PIC, dataCoverPic)
            putExtra(NewsDetailActivity.DATA_PUBLISH_TIME, dataPublishTime)
            putExtra(NewsDetailActivity.DATA_TITLE, dataTitle)
            putExtra(NewsDetailActivity.DATA_DESCRIPTION, dataDescription)
        }

}