package com.fachrizalmrsln.component.base.database

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*

@Dao
interface NewsDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun bookmarkingData(dataBookmark: NewsBookmarkEntity)

    @Query("SELECT * from news_list_bookmark ORDER BY publishTime DESC")
    fun getDataBookmark(): DataSource.Factory<Int, NewsBookmarkEntity>

    @Delete
    fun unBookmarkingData(dataBookmark: NewsBookmarkEntity): Int

    @Query("SELECT * from news_list_bookmark WHERE id = :dataID")
    fun getDataBookmarkDetail(dataID: Int): LiveData<NewsBookmarkEntity>

}