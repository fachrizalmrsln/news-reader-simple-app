package com.fachrizalmrsln.component.base.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news_list_bookmark")
data class NewsBookmarkEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int = 0,
    val title: String,
    val category: String,
    val description: String,
    val detailUrl: String,
    val publishTime: Int,
    val coverPic: String?
)