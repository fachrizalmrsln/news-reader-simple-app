package com.fachrizalmrsln.newsreadersimple.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.fachrizalmrsln.component.base.database.NewsBookmarkEntity
import com.fachrizalmrsln.component.base.database.NewsDAO

@Database(
    entities = [NewsBookmarkEntity::class],
    version = 1
)
abstract class NewsAppDatabase : RoomDatabase() {

    abstract fun newsDao(): NewsDAO

    companion object {
        private const val DatabaseName = "NewsDB"
        var INSTANCE: NewsAppDatabase? = null

        fun getDatabase(context: Context): NewsAppDatabase {
            if (INSTANCE == null) {
                synchronized(Database::class.java) {
                    INSTANCE = Room.databaseBuilder(
                        context,
                        NewsAppDatabase::class.java,
                        DatabaseName
                    ).build()
                }
            }
            return INSTANCE as NewsAppDatabase
        }
    }

}