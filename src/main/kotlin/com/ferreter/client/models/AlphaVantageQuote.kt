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
    val symbol: String? = null,
    @SerialName("02. open")
    val open: Double? = null,
    @SerialName("03. high")
    val high: Double? = null,
    @SerialName("04. low")
    val low: Double? = null,
    @SerialName("05. price")
    val price: Double? = null,
    @SerialName("06. volume")
    val volume: Long? = null,
    @SerialName("07. latest trading day")
    val latestTradingDay: String? = null,
    @SerialName("08. previous close")
    val previousClose: Double? = null,
    @SerialName("09. change")
    val change: Double? = null,
    @SerialName("10. change percent")
    val changePercent: String? = null,
)