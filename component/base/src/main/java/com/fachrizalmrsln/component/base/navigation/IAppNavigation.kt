package com.fachrizalmrsln.component.base.navigation

import android.content.Context

interface IAppNavigation {

    fun navigateToNewsList(context: Context)

    fun navigateToNewsDetail(
        context: Context,
        dataID: Int,
        dataDetail: String,
        dataCategory: String,
        dataCoverPic: String?,
        dataPublishTime: Int,
        dataTitle: String,
        dataDescription: String
    )

}