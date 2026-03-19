package com.rudy.kmpstarterproductionlite.presentation.items

import com.rudy.kmpstarterproductionlite.domain.model.Item
import com.rudy.kmpstarterproductionlite.util.Result

data class ItemsUiState(
    val result: Result<List<Item>> = Result.Loading
)
