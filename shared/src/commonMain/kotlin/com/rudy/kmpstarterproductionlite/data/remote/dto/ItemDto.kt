package com.rudy.kmpstarterproductionlite.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class ItemDto(
    val id: Long,
    val title: String,
    val description: String
)
