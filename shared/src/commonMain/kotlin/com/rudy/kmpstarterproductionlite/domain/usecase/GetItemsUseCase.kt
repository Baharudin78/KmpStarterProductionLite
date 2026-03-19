package com.rudy.kmpstarterproductionlite.domain.usecase

import com.rudy.kmpstarterproductionlite.domain.model.Item
import com.rudy.kmpstarterproductionlite.domain.repository.ItemRepository
import com.rudy.kmpstarterproductionlite.util.Result

class GetItemsUseCase(
    private val repository: ItemRepository
) {
    suspend operator fun invoke(): Result<List<Item>> {
        return repository.getItems()
    }
}
