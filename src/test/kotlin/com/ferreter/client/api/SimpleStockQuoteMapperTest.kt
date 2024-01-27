package com.ferreter.client.api

import com.ferreter.client.models.AlphaVantageQuote
import com.ferreter.client.models.GlobalQuote
import com.ferreter.client.models.SimpleStockQuote
import org.junit.Assert.*
import kotlin.test.BeforeTest
import kotlin.test.Test

class SimpleStockQuoteMapperTest {
    private lateinit var mapper: SimpleStockQuoteMapper

    @BeforeTest
    fun setUp() {
        mapper = SimpleStockQuoteMapperImpl()
    }

    @Test
    fun `when quote data is provided, then return the corresponding SimpleStockQuote`() {
        val price = 31.12
        val symbol = "symbol"
        val randomLong = 9L
        val randomDouble = 12.05
        val randomString = "random"
        val change = 19.07
        val changePercent = "61.28%"
        val alphaVantageQuote = AlphaVantageQuote(
            globalQuote = GlobalQuote(
                symbol = symbol,
                open = randomDouble,
                high = randomDouble,
                low = randomDouble,
                price = price,
                volume = randomLong,
                latestTradingDay = randomString,
                previousClose = randomDouble,
                change = change,
                changePercent = changePercent,
            )
        )

        val expectedQuote = SimpleStockQuote(
            price = price,
            symbol = symbol,
            change = change,
            changePercent = changePercent,
        )
        val actualQuote = mapper.map(alphaVantageQuote)
        assertEquals(expectedQuote, actualQuote)
    }
}
