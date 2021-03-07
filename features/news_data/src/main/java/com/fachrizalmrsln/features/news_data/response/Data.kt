package com.fachrizalmrsln.features.news_data.response

data class Data(
    val nextPage: String,
    val rows: List<Row>,
    val size: Int
)