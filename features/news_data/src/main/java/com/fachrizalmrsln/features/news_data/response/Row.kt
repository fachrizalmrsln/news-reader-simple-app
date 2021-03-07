package com.fachrizalmrsln.features.news_data.response

data class Row(
    val articleFrom: String,
    val category: String,
    val city: String,
    val coverPic: List<String>?,
    val description: String,
    val detailUrl: String,
    val id: Int,
    val keyword: String,
    val language: String,
    val originalUrl: String,
    val pages: List<Page>,
    val province: String,
    val publishTime: Int,
    val subcategory: String,
    val summary: String,
    val tags: List<String>,
    val title: String,
    val isBookmarked: Boolean = false
)