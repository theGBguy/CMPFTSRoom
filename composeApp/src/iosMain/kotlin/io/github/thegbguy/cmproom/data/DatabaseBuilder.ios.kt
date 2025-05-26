package io.github.thegbguy.cmproom.data

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.cinterop.ExperimentalForeignApi
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSURL
import platform.Foundation.NSUserDomainMask

@OptIn(ExperimentalForeignApi::class)
private fun getDatabasePath(): String {
    val documentDirectory: NSURL? = NSFileManager.defaultManager.URLsForDirectory(
        directory = NSDocumentDirectory,
        inDomains = NSUserDomainMask
    ).firstOrNull() as? NSURL
    return documentDirectory?.URLByAppendingPathComponent("articles.db")?.path ?: "articles.db"
}

class IOSDatabaseBuilder : DatabaseBuilder {
    override fun build(): AppDatabase {
        return Room.databaseBuilder<AppDatabase>(
            name = getDatabasePath()
        ).setDriver(BundledSQLiteDriver())
            .fallbackToDestructiveMigration(false).build()
    }
}