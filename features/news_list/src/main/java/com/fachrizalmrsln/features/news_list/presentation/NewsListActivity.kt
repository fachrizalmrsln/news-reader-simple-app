package com.fachrizalmrsln.features.news_list.presentation

import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import com.fachrizalmrsln.component.base.activity.BaseViewBindingActivity
import com.fachrizalmrsln.component.base.database.NewsListEntity
import com.fachrizalmrsln.component.base.extensions.gone
import com.fachrizalmrsln.component.base.extensions.loadImageFromAssets
import com.fachrizalmrsln.component.base.extensions.visible
import com.fachrizalmrsln.component.base.navigation.IAppNavigation
import com.fachrizalmrsln.component.base.util.RecyclerViewPaging
import com.fachrizalmrsln.features.news_list.R
import com.fachrizalmrsln.features.news_list.databinding.ActivityNewsListBinding
import com.faltenreich.skeletonlayout.Skeleton
import com.faltenreich.skeletonlayout.applySkeleton
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewsListActivity : BaseViewBindingActivity<ActivityNewsListBinding>() {

    private val viewModel by viewModel<NewsListViewModel>()
    private val navigation by inject<IAppNavigation>()

    private val newsListAdapter = NewsListAdapter()
    private val newsListBookmarkAdapter = NewsListBookmarkAdapter()

    private lateinit var skeleton: Skeleton

    private var mPage = 1
    private var mFirstLoading = true
    private var mTotalPage = 10
    private var mPosition = 0

    private var bookmarkIsEmpty = false
    private var isBookmarkListShow = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeObserver()
    }

    override fun setupComponent() {
        initializeNewsList()
        initializeNewsListBookmark()

        getNewsListData(mPage)

        onClickHandler()
    }

    override val bindingInflater: (LayoutInflater) -> ActivityNewsListBinding
        get() = ActivityNewsListBinding::inflate

    private fun initializeObserver() {
        viewModel.message.observe(this) { message ->
            showMessage(message)
        }
        viewModel.loadingStatus.observe(this) { isLoading ->
            if (mFirstLoading) {
                if (isLoading) uiFirstLoading()
                else {
                    uiDoneFirstLoading()
                    mFirstLoading = false
                }
            } else {
                if (isLoading) uiLoading() else uiDoneLoading()
            }
        }
        viewModel.newsListResponse.observe(this) { response ->
            newsListAdapter.insertData(response)
        }
        viewModel.getDataBookmarkList().observe(this) { newsListBookmark ->
            if (newsListBookmark.isNullOrEmpty()) {
                bookmarkIsEmpty = true
                checkBookmarkListState()
            } else {
                newsListBookmarkAdapter.insertData(newsListBookmark)
                bookmarkIsEmpty = false
            }
        }
    }

    private fun initializeNewsList() {
        binding.rvNewsList.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = newsListAdapter
            hasFixedSize()
            addOnScrollListener(RecyclerViewPaging {
                if (mPage <= mTotalPage) {
                    mPage += 1
                    mPosition += it
                    getNewsListData(mPage)
                    binding.rvNewsList.scrollToPosition(mPosition)
                }
            })
        }
        initializeSkeleton()
    }

    private fun initializeNewsListBookmark() {
        binding.rvNewsBookmark.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = newsListBookmarkAdapter
            hasFixedSize()
        }
    }

    private fun initializeSkeleton() {
        skeleton = binding.rvNewsList.applySkeleton(R.layout.item_news_list)
    }

    private fun uiFirstLoading() {
        skeleton.showSkeleton()
    }

    private fun uiDoneFirstLoading() {
        skeleton.showOriginal()
    }

    private fun uiLoading() {
        binding.pbNewsList.visible()
    }

    private fun uiDoneLoading() {
        binding.pbNewsList.gone()
    }

    private fun uiBookmarkListShow() {
        isBookmarkListShow = true
        checkBookmarkListState()
        binding.rvNewsList.gone()
        binding.includeToolbar.ivBookmarkToolbar.loadImageFromAssets(R.drawable.ic_bookmark_white)
    }

    private fun uiBookmarkListHide() {
        isBookmarkListShow = false
        binding.includeToolbar.ivBookmarkToolbar.loadImageFromAssets(R.drawable.ic_bookmark_withe_line)
        binding.rvNewsList.visible()
        binding.rvNewsBookmark.gone()
        binding.tvEmptyBookmark.gone()
    }

    private fun checkBookmarkListState() {
        if (bookmarkIsEmpty) {
            if (isBookmarkListShow) {
                binding.tvEmptyBookmark.visible()
                binding.rvNewsBookmark.gone()
            } else {
                binding.tvEmptyBookmark.gone()
                binding.rvNewsBookmark.gone()
            }
        } else {
            binding.tvEmptyBookmark.gone()
            binding.rvNewsBookmark.visible()
        }
    }

    private fun onClickHandler() {
        binding.includeToolbar.ivBookmarkToolbar.apply {
            setOnClickListener {
                if (isBookmarkListShow) uiBookmarkListHide() else uiBookmarkListShow()
            }
        }
        onAdapterNewsListClicked()
        onAdapterNewsListBookmarkClicked()
    }

    private fun onAdapterNewsListClicked() {
        newsListAdapter.onItemClickHandler { data ->
            navigation.navigateToNewsDetail(
                this,
                data.id,
                data.detailUrl,
                data.category,
                data.coverPic,
                data.publishTime,
                data.title,
                data.description
            )
        }
        newsListAdapter.onItemBookmarkClickHandler { data ->
            if (data.isBookmarked) unBookmarkingItem(data)
            else bookmarkingItem(data)
        }
    }

    private fun onAdapterNewsListBookmarkClicked() {
        newsListBookmarkAdapter.onItemClickHandler { data ->
            navigation.navigateToNewsDetail(
                this,
                data.id,
                data.detailUrl,
                data.category,
                data.coverPic,
                data.publishTime,
                data.title,
                data.description
            )
        }
        newsListBookmarkAdapter.onItemBookmarkClickHandler { data, position, size ->
            unBookmarkingItem(data)
            newsListBookmarkAdapter.removeData(position)
            if (size == 1) {
                bookmarkIsEmpty = true
                uiBookmarkListShow()
            }
        }
    }

    private fun getNewsListData(page: Int) {
        launch { viewModel.getNewsList(page) }
    }

    private fun bookmarkingItem(data: NewsListEntity) {
        val dataBookmark = NewsListEntity(
            id = data.id,
            title = data.title,
            category = data.category,
            description = data.description,
            detailUrl = data.detailUrl,
            publishTime = data.publishTime,
            coverPic = data.coverPic,
            isBookmarked = true
        )
        viewModel.bookmarkingData(dataBookmark)
    }

    private fun unBookmarkingItem(data: NewsListEntity) {
        val dataBookmark = NewsListEntity(
            id = data.id,
            title = data.title,
            category = data.category,
            description = data.description,
            detailUrl = data.detailUrl,
            publishTime = data.publishTime,
            coverPic = data.coverPic
        )
        viewModel.unBookmarkingData(dataBookmark)
    }

    override fun onBackPressed() {
        if (isBookmarkListShow) {
            isBookmarkListShow = false
            uiBookmarkListHide()
        } else {
            super.onBackPressed()
        }
    }

}