package com.fachrizalmrsln.features.news_list.presenter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.fachrizalmrsln.component.base.database.NewsBookmarkEntity
import com.fachrizalmrsln.component.base.extensions.convertTimeStamp
import com.fachrizalmrsln.component.base.extensions.loadImage
import com.fachrizalmrsln.component.base.extensions.loadImageFromAssets
import com.fachrizalmrsln.features.news_list.R
import com.github.marlonlom.utilities.timeago.TimeAgo
import splitties.views.onClick

class NewsListBookmarkAdapter :
    RecyclerView.Adapter<NewsListBookmarkAdapter.NewsListBookmarkViewHolder>() {

    private val mNewsListDataBookmark = mutableListOf<NewsBookmarkEntity>()
    private lateinit var mOnItemClickHandler: (data: NewsBookmarkEntity) -> Unit
    private lateinit var mOnItemBookmarkClickHandler: (data: NewsBookmarkEntity, position: Int, size: Int) -> Unit

    fun onItemClickHandler(listener: (data: NewsBookmarkEntity) -> Unit) {
        mOnItemClickHandler = listener
    }

    fun onItemBookmarkClickHandler(listener: (data: NewsBookmarkEntity, position: Int, size: Int) -> Unit) {
        mOnItemBookmarkClickHandler = listener
    }

    fun insertData(data: List<NewsBookmarkEntity>) {
        mNewsListDataBookmark.clear()
        mNewsListDataBookmark.addAll(data)
        notifyDataSetChanged()
    }

    fun removeData(position: Int) {
        notifyItemRemoved(position)
        if (mNewsListDataBookmark.size == 1) {
            mNewsListDataBookmark.clear()
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsListBookmarkViewHolder {
        return NewsListBookmarkViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_news_list, parent, false)
        )
    }

    override fun onBindViewHolder(holder: NewsListBookmarkViewHolder, position: Int) {
        holder.bindData(
            mNewsListDataBookmark[position],
            position,
            mNewsListDataBookmark.size,
            mOnItemClickHandler,
            mOnItemBookmarkClickHandler
        )
    }

    override fun getItemCount(): Int {
        return mNewsListDataBookmark.size
    }

    inner class NewsListBookmarkViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val clItem = itemView.findViewById<ConstraintLayout>(R.id.cl_item)
        private val ivBackDrop = itemView.findViewById<ImageView>(R.id.iv_image_backdrop)
        private val clBookmark = itemView.findViewById<ConstraintLayout>(R.id.cl_menu_bookmark)
        private val ivBookmark = itemView.findViewById<ImageView>(R.id.iv_bookmark_item)
        private val tvTime = itemView.findViewById<TextView>(R.id.tv_time)
        private val tvTitle = itemView.findViewById<TextView>(R.id.tv_title)
        private val tvSubTitle = itemView.findViewById<TextView>(R.id.tv_sub_title)

        private var bookmarkState = false

        fun bindData(
            data: NewsBookmarkEntity,
            position: Int,
            size: Int,
            listener: (data: NewsBookmarkEntity) -> Unit,
            bookmarkListener: (data: NewsBookmarkEntity, position: Int, size: Int) -> Unit
        ) {
            val imageBackDrop = data.coverPic

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

            ivBookmark.loadImageFromAssets(R.drawable.ic_bookmark_filled)
            clBookmark.onClick {
                bookmarkState = if (bookmarkState) {
                    ivBookmark.loadImageFromAssets(R.drawable.ic_bookmark_filled)
                    false
                } else {
                    ivBookmark.loadImageFromAssets(R.drawable.ic_bookmark)
                    true
                }
                bookmarkListener.invoke(data, position, size)

            }
        }

    }

}