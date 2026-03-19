package com.rudy.kmpstarterproductionlite.data.repository

import com.rudy.kmpstarterproductionlite.data.local.dao.ItemDao
import com.rudy.kmpstarterproductionlite.data.mapper.toDomain
import com.rudy.kmpstarterproductionlite.data.mapper.toEntity
import com.rudy.kmpstarterproductionlite.data.remote.ItemApi
import com.rudy.kmpstarterproductionlite.domain.model.Item
import com.rudy.kmpstarterproductionlite.domain.repository.ItemRepository
import com.rudy.kmpstarterproductionlite.util.Result
import com.rudy.kmpstarterproductionlite.util.safeApiCall

class ItemRepositoryImpl(
    private val itemApi: ItemApi,
    private val itemDao: ItemDao
) : ItemRepository {

    override suspend fun getItems(): Result<List<Item>> {
        return safeApiCall {
            val remoteItems = itemApi.getItems()
            val entities = remoteItems.map { it.toEntity() }
            itemDao.insertAll(entities)
            itemDao.getAllItems().map { it.toDomain() }
        }
    }

    override suspend fun getItemById(id: Long): Result<Item> {
        return safeApiCall {
            val remoteItem = itemApi.getItemById(id)
            val entity = remoteItem.toEntity()
            itemDao.insert(entity)
            entity.toDomain()
        }
    }
}
