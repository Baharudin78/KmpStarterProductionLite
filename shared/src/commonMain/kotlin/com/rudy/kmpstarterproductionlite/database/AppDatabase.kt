package com.rudy.kmpstarterproductionlite.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rudy.kmpstarterproductionlite.data.local.dao.ItemDao
import com.rudy.kmpstarterproductionlite.database.entity.ItemEntity

@Database(
    entities = [ItemEntity::class],
    version = 1,
    exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun itemDao(): ItemDao
}
