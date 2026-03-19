package com.rudy.kmpstarterproductionlite.data.mapper

import com.rudy.kmpstarterproductionlite.data.remote.dto.ItemDto
import com.rudy.kmpstarterproductionlite.database.entity.ItemEntity
import com.rudy.kmpstarterproductionlite.domain.model.Item

fun ItemDto.toDomain(): Item {
    return Item(
        id = id,
        title = title,
        description = description
    )
}

fun ItemDto.toEntity(): ItemEntity {
    return ItemEntity(
        id = id,
        title = title,
        description = description
    )
}

fun ItemEntity.toDomain(): Item {
    return Item(
        id = id,
        title = title,
        description = description
    )
}

fun Item.toEntity(): ItemEntity {
    return ItemEntity(
        id = id,
        title = title,
        description = description
    )
}
