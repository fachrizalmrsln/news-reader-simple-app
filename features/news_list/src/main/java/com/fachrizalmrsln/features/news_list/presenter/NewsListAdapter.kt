package com.fachrizalmrsln.features.news_list.presenter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.fachrizalmrsln.component.base.extensions.convertTimeStamp
import com.fachrizalmrsln.component.base.extensions.loadImage
import com.fachrizalmrsln.component.base.extensions.loadImageFromAssets
import com.fachrizalmrsln.features.news_data.response.Row
import com.fachrizalmrsln.features.news_list.R
import com.github.marlonlom.utilities.timeago.TimeAgo
import splitties.views.onClick

class NewsListAdapter : RecyclerView.Adapter<NewsListAdapter.NewsListViewHolder>() {

    private val mNewsListData = mutableListOf<Row>()
    private lateinit var mOnItemClickHandler: (data: Row) -> Unit
    private lateinit var mOnItemBookmarkClickHandler: (data: Row) -> Unit

    fun onItemClickHandler(listener: (data: Row) -> Unit) {
        mOnItemClickHandler = listener
    }

    fun onItemBookmarkClickHandler(listener: (data: Row) -> Unit) {
        mOnItemBookmarkClickHandler = listener
    }

    fun insertData(data: List<Row>) {
        mNewsListData.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsListViewHolder {
        return NewsListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_news_list, parent, false)
        )
    }

    override fun onBindViewHolder(holder: NewsListViewHolder, position: Int) {
        holder.bindData(
            mNewsListData[position],
            mOnItemClickHandler,
            mOnItemBookmarkClickHandler
        )
    }

    override fun getItemCount(): Int {
        return mNewsListData.size
    }

    inner class NewsListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val clItem = itemView.findViewById<ConstraintLayout>(R.id.cl_item)
        private val ivBackDrop = itemView.findViewById<ImageView>(R.id.iv_image_backdrop)
        private val clBookmark = itemView.findViewById<ConstraintLayout>(R.id.cl_menu_bookmark)
        private val ivBookmark = itemView.findViewById<ImageView>(R.id.iv_bookmark_item)
        private val tvTime = itemView.findViewById<TextView>(R.id.tv_time)
        private val tvTitle = itemView.findViewById<TextView>(R.id.tv_title)
        private val tvSubTitle = itemView.findViewById<TextView>(R.id.tv_sub_title)

        private var bookmarkState = false

        fun bindData(
            data: Row,
            listener: (data: Row) -> Unit,
            bookmarkListener: (data: Row) -> Unit
        ) {
            val imageBackDrop = data.coverPic?.get(0)

            if (imageBackDrop != null) ivBackDrop.loadImage(
                imageBackDrop,
                R.drawable.ic_place_holder_image
            )
            else ivBackDrop.loadImageFromAssets(R.drawable.ic_place_holder_image)

            tvTime.text = TimeAgo.using(data.publishTime.convertTimeStamp())
            tvTitle.text = data.title
            tvSubTitle.text = data.description

            clItem.onClick {
                listener.invoke(data)
            }

            clBookmark.onClick {
                bookmarkState = if (bookmarkState) {
                    ivBookmark.loadImageFromAssets(R.drawable.ic_bookmark)
                    false
                } else {
                    ivBookmark.loadImageFromAssets(R.drawable.ic_bookmark_filled)
                    true
                }
                bookmarkListener.invoke(data)

            }
        }

    }

}