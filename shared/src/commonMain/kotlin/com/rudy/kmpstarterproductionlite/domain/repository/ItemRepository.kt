package com.rudy.kmpstarterproductionlite.domain.repository

import com.rudy.kmpstarterproductionlite.domain.model.Item
import com.rudy.kmpstarterproductionlite.util.Result

interface ItemRepository {
    suspend fun getItems(): Result<List<Item>>
    suspend fun getItemById(id: Long): Result<Item>
}
