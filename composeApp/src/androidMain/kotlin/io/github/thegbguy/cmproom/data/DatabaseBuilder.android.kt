package io.github.thegbguy.cmproom.data

import android.content.Context
import androidx.room.Room

class AndroidDatabaseBuilder(private val appContext: Context) : DatabaseBuilder {
    override fun build(): AppDatabase {
        return Room.databaseBuilder<AppDatabase>(
            context = appContext,
            name = "articles.db"
        ).fallbackToDestructiveMigration(false)
            .build()
    }
}