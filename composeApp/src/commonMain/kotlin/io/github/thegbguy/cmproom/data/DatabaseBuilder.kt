package io.github.thegbguy.cmproom.data

interface DatabaseBuilder {
    fun build(): AppDatabase
}

object AppInitializer {
    private var database: AppDatabase? = null
    fun init(builder: DatabaseBuilder) {
        if (database != null) return
        database = builder.build()
    }

    fun getDatabase(): AppDatabase {
        return database ?: throw IllegalStateException("Database not initialized")
    }
}
