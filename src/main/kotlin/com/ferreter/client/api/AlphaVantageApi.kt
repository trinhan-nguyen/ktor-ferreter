package com.ferreter.client.api

import com.ferreter.client.models.AlphaVantageQuote

interface AlphaVantageApi {
    suspend fun getQuote(
        symbol: String,
        apiKey: String,
    ): AlphaVantageQuote
}
