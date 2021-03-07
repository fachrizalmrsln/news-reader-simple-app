package com.fachrizalmrsln.features.news_list.database

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*

@Dao
interface NewsListDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun bookmarkingData(dataBookmark: NewsListBookmarkEntity)

    @Query("SELECT * from news_list_bookmark ORDER BY publishTime DESC")
    fun getDataBookmark(): DataSource.Factory<Int, NewsListBookmarkEntity>

    @Delete
    fun unBookmarkingData(dataBookmark: NewsListBookmarkEntity): Int

    @Query("SELECT * from news_list_bookmark WHERE id = :dataID")
    fun getDataBookmarkDetail(dataID: Int): LiveData<NewsListBookmarkEntity>

}