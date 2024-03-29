package com.ferreter

import com.ferreter.client.api.AlphaVantageApi
import com.ferreter.client.models.ErrorMessage
import com.ferreter.client.models.SimpleStockQuote
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.config.*
import io.ktor.server.testing.*
import kotlinx.serialization.json.Json
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module
import org.koin.test.KoinTest
import org.mockito.kotlin.eq
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class ApplicationTest : KoinTest {
    private lateinit var api: AlphaVantageApi

    private val apiKey = "apiKey"
    private val expectedQuote = SimpleStockQuote(
        symbol = "symbol",
        price = 69.96,
        change = 34.98,
        changePercent = "100%",
    )

    @BeforeTest
    fun setUp() {
        api = mock()
        startKoin {
            modules(
                module {
                    single<AlphaVantageApi> { api }
                }
            )
        }
    }

    @AfterTest
    fun tearDown() {
        stopKoin()
    }

    @Test
    fun `when the api returns stock data, then return the corresponding simplified quote`() = testApplication {
        // Arrange
        val tickerSymbol = "tickerSymbol"
        whenever(api.getQuote(symbol = eq(tickerSymbol), apiKey = eq(apiKey)))
            .thenReturn(expectedQuote)
        application {
            module(isProduction = false)
        }
        environment {
            config = MapApplicationConfig("ktor.environment" to apiKey)
        }
        val json = Json { prettyPrint = true }

        // Act
        val response = client.get("/quote/$tickerSymbol")
        val actualQuote = json.decodeFromString<SimpleStockQuote>(response.bodyAsText())

        // Assert
        assertEquals(
            expected = HttpStatusCode.OK,
            actual = response.status,
        )
        assertEquals(
            expected = expectedQuote,
            actual = actualQuote,
        )
    }

    @Test
    fun `when the api key is not provided, then return a corresponding error message`() = testApplication {
        // Arrange
        val tickerSymbol = "tickerSymbol"
        whenever(api.getQuote(symbol = eq(tickerSymbol), apiKey = eq(apiKey)))
            .thenReturn(expectedQuote)
        application {
            module(isProduction = false)
        }
        environment {
            config = MapApplicationConfig()
        }
        val json = Json { prettyPrint = true }

        // Act
        val response = client.get("/quote/$tickerSymbol")
        val errorMessage = json.decodeFromString<ErrorMessage>(response.bodyAsText())

        // Assert
        assertEquals(
            expected = HttpStatusCode.OK,
            actual = response.status,
        )
        assertEquals(
            expected = ErrorMessage(errorMessage = "Failed to get the API key!"),
            actual = errorMessage,
        )
    }
}
