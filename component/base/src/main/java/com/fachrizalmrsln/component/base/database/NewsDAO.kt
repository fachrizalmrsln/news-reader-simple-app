package com.fachrizalmrsln.component.base.database

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*

@Dao
interface NewsDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertNewsListToDB(dataNewsList: List<NewsListEntity>)

    @Query("SELECT * FROM news_list ORDER BY publishTime DESC")
    fun getNewsList(): DataSource.Factory<Int, NewsListEntity>

    @Update
    fun bookmarkingData(dataBookmark: NewsListEntity)

    @Query("SELECT * from news_list WHERE isBookmarked = 1 ORDER BY publishTime DESC")
    fun getDataBookmark(): DataSource.Factory<Int, NewsListEntity>

    @Update
    fun unBookmarkingData(dataBookmark: NewsListEntity)

    @Query("SELECT * from news_list WHERE id = :dataID AND isBookmarked = 1")
    fun getDataBookmarkDetail(dataID: Int): LiveData<NewsListEntity>

}