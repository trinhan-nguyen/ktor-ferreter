package com.ferreter.client.api

import com.ferreter.client.models.AlphaVantageQuote
import com.ferreter.client.models.SimpleStockQuote

interface SimpleStockQuoteMapper {
    fun map(quote: AlphaVantageQuote): SimpleStockQuote
}

class SimpleStockQuoteMapperImpl : SimpleStockQuoteMapper {
    override fun map(quote: AlphaVantageQuote): SimpleStockQuote {
        val globalQuote = quote.globalQuote
        return SimpleStockQuote(
            price = globalQuote.price,
            symbol = globalQuote.symbol,
            change = globalQuote.change,
            changePercent = globalQuote.changePercent,
        )
    }
}
