package com.fachrizalmrsln.component.base.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news_list")
data class NewsListEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int = 0,
    val title: String,
    val category: String,
    val description: String,
    val detailUrl: String,
    val publishTime: Int,
    val coverPic: String?,
    val isBookmarked: Boolean = false
)