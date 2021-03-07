package com.fachrizalmrsln.features.news_list.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [NewsListBookmarkEntity::class],
    version = 1
)
abstract class NewsListDatabase : RoomDatabase() {

    abstract fun newsListDao(): NewsListDAO

    companion object {
        private const val DatabaseName = "NewsDB"
        var INSTANCE: NewsListDatabase? = null

        fun getDatabase(context: Context): NewsListDatabase {
            if (INSTANCE == null) {
                synchronized(Database::class.java) {
                    INSTANCE = Room.databaseBuilder(
                        context,
                        NewsListDatabase::class.java,
                        DatabaseName
                    ).build()
                }
            }
            return INSTANCE as NewsListDatabase
        }
    }

}