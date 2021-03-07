package com.fachrizalmrsln.features.news_list.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news_list_bookmark")
data class NewsListBookmarkEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int = 0,
    val title: String,
    val category: String,
    val description: String,
    val detailUrl: String,
    val publishTime: Int,
    val coverPic: String?
)