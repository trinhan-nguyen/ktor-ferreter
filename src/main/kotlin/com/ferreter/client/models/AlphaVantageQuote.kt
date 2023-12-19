package com.ferreter.client.models

import kotlinx.serialization.Serializable

@Serializable
data class AlphaVantageQuote(
    val globalQuote: GlobalQuote,
)

@Serializable
data class GlobalQuote(
    val symbol: String,
    val open: Double,
    val high: Double,
    val low: Double,
    val price: Double,
    val volume: Long,
    val latestTradingDay: String,
    val previousClose: Double,
    val change: Double,
    val changePercent: Double,
)
