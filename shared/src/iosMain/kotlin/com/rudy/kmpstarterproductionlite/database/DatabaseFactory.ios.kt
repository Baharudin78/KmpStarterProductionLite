package com.rudy.kmpstarterproductionlite.database

import androidx.room.Room
import androidx.room.RoomDatabase
import platform.Foundation.NSHomeDirectory

actual class DatabaseFactory {
    actual fun create(): RoomDatabase.Builder<AppDatabase> {
        val dbFile = NSHomeDirectory() + "/app.db"
        return Room.databaseBuilder<AppDatabase>(
            name = dbFile
        )
    }
}
