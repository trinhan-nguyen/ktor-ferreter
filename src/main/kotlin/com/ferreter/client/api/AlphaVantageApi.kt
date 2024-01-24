package com.ferreter.client.api

import com.ferreter.client.models.SimpleStockQuote

interface AlphaVantageApi {
    suspend fun getQuote(
        symbol: String,
        apiKey: String,
    ): SimpleStockQuote
}
