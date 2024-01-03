package com.ferreter.client.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AlphaVantageQuote(
    @SerialName("Global Quote")
    val globalQuote: GlobalQuote,
)

@Serializable
data class GlobalQuote(
    @SerialName("01. symbol")
    val symbol: String,
    @SerialName("02. open")
    val open: Double,
    @SerialName("03. high")
    val high: Double,
    @SerialName("04. low")
    val low: Double,
    @SerialName("05. price")
    val price: Double,
    @SerialName("06. volume")
    val volume: Long,
    @SerialName("07. latest trading day")
    val latestTradingDay: String,
    @SerialName("08. previous close")
    val previousClose: Double,
    @SerialName("09. change")
    val change: Double,
    @SerialName("10. change percent")
    val changePercent: String,
)