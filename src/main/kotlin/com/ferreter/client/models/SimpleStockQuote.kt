package com.ferreter.client.models

import kotlinx.serialization.Serializable

@Serializable
data class SimpleStockQuote(
    val price: Double,
    val symbol: String,
    val change: Double,
    val changePercent: String,
)
