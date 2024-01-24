package com.ferreter.client.models

data class SimpleStockQuote(
    val symbol: String,
    val price: Double,
    val change: Double,
    val changePercent: String,
)
