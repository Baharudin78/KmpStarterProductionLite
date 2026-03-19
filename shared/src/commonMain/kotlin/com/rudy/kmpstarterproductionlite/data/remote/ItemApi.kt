package com.rudy.kmpstarterproductionlite.data.remote

import com.rudy.kmpstarterproductionlite.data.remote.dto.ItemDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ItemApi(private val httpClient: HttpClient) {

    suspend fun getItems(): List<ItemDto> {
        return httpClient.get("items").body()
    }

    suspend fun getItemById(id: Long): ItemDto {
        return httpClient.get("items/$id").body()
    }
}
