package com.rudy.kmpstarterproductionlite.database

import androidx.room.RoomDatabase

expect class DatabaseFactory {
    fun create(): RoomDatabase.Builder<AppDatabase>
}

fun getDatabaseBuilder(factory: DatabaseFactory): AppDatabase {
    return factory.create()
        .fallbackToDestructiveMigration(true)
        .build()
}
