package com.fachrizalmrsln.features.news_detail.presenter

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.lifecycle.LiveData
import com.fachrizalmrsln.component.base.activity.BaseViewBindingActivity
import com.fachrizalmrsln.component.base.extensions.gone
import com.fachrizalmrsln.component.base.extensions.loadImageFromAssets
import com.fachrizalmrsln.component.base.extensions.makeFirstIndexCapitalize
import com.fachrizalmrsln.component.base.extensions.visible
import com.fachrizalmrsln.features.news_detail.R
import com.fachrizalmrsln.features.news_detail.databinding.ActivityNewsDetailBinding
import com.fachrizalmrsln.features.news_list.database.NewsListBookmarkEntity
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewsDetailActivity : BaseViewBindingActivity<ActivityNewsDetailBinding>() {

    private val viewModel by viewModel<NewsDetailViewModel>()

    companion object {
        const val DATA_ID = "data_id"
        const val DATA_CATEGORY = "data_category"
        const val DATA_DETAIL = "data_detail"
        const val DATA_COVER_PIC = "data_cover_pic"
        const val DATA_PUBLISH_TIME = "data_publish_time"
        const val DATA_TITLE = "data_title"
        const val DATA_DESCRIPTION = "data_description"
    }

    private var isBookmarkState = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeObserver()
    }

    override fun setupComponent() {
        initializeToolbar()
        initializeData()

        onClickHandler()
    }

    override val bindingInflater: (LayoutInflater) -> ActivityNewsDetailBinding
        get() = ActivityNewsDetailBinding::inflate

    private fun initializeObserver() {
        getDataBookmarkDetail(intent.getIntExtra(DATA_ID, 0)).observe(this) { bookmarkDetail ->
            if (bookmarkDetail == null) uiUnBookmarked() else uiBookmarked()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun initializeToolbar() {
        binding.includeDetailToolbar.tvTitle.text = "Detik " +
                intent.getStringExtra(DATA_CATEGORY)?.makeFirstIndexCapitalize()
        binding.includeDetailToolbar.ivBack.setOnClickListener { finish() }
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun initializeData() {
        intent.getStringExtra(DATA_DETAIL)?.let { dataDetail ->
            binding.webViewDetail.apply {
                settings.allowFileAccess = true
                settings.javaScriptEnabled = true
                settings.cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK

                loadUrl(dataDetail)
                webViewClient = object : WebViewClient() {
                    override fun onPageFinished(view: WebView?, url: String?) {
                        super.onPageFinished(view, url)
                        visible()
                        binding.pbLoading.gone()
                    }
                }
            }
        }
    }

    private fun onClickHandler() {
        binding.includeDetailToolbar.ivBookmarkToolbar.apply {
            setOnClickListener {
                if (isBookmarkState) {
                    uiUnBookmarked()
                    unBookmarkingData()
                } else {
                    uiBookmarked()
                    bookmarkingData()
                }
            }
        }
    }

    private fun uiBookmarked() {
        isBookmarkState = true
        binding.includeDetailToolbar.ivBookmarkToolbar.loadImageFromAssets(R.drawable.ic_bookmark_white)
    }

    private fun uiUnBookmarked() {
        isBookmarkState = false
        binding.includeDetailToolbar.ivBookmarkToolbar.loadImageFromAssets(R.drawable.ic_bookmark_withe_line)
    }

    private fun bookmarkingData() {
        val dataBookmark = NewsListBookmarkEntity(
            id = intent.getIntExtra(DATA_ID, 0),
            category = intent.getStringExtra(DATA_CATEGORY) ?: "",
            detailUrl = intent.getStringExtra(DATA_DETAIL) ?: "",
            title = intent.getStringExtra(DATA_TITLE) ?: "",
            description = intent.getStringExtra(DATA_DESCRIPTION) ?: "",
            publishTime = intent.getIntExtra(DATA_PUBLISH_TIME, 0),
            coverPic = intent.getStringExtra(DATA_COVER_PIC)
        )
        viewModel.bookmarkingData(dataBookmark)
    }

    private fun getDataBookmarkDetail(dataID: Int): LiveData<NewsListBookmarkEntity> {
        return viewModel.getDataBookmarkDetail(dataID)
    }

    private fun unBookmarkingData() {
        val dataBookmark = NewsListBookmarkEntity(
            id = intent.getIntExtra(DATA_ID, 0),
            category = intent.getStringExtra(DATA_CATEGORY) ?: "",
            detailUrl = intent.getStringExtra(DATA_DETAIL) ?: "",
            title = intent.getStringExtra(DATA_TITLE) ?: "",
            description = intent.getStringExtra(DATA_DESCRIPTION) ?: "",
            publishTime = intent.getIntExtra(DATA_PUBLISH_TIME, 0),
            coverPic = intent.getStringExtra(DATA_COVER_PIC)
        )
        viewModel.unBookmarkingData(dataBookmark)
    }

}