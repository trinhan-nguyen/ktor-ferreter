package com.ferreter.client.api

import com.ferreter.client.models.AlphaVantageQuote
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*

class AlphaVantageApiImpl : AlphaVantageApi {
    override suspend fun getQuote(
        symbol: String,
        apiKey: String,
    ): AlphaVantageQuote {
        val httpClient = HttpClient {
            install(ContentNegotiation) {
                json()
            }
        }
        val response = httpClient.get {
            url {
                protocol = URLProtocol.HTTPS
                host = ALPHA_VANTAGE_URL
                path("query")
                parameters.append(name = "function", value = "GLOBAL_QUOTES")
                parameters.append(name = "symbol", value = symbol)
                parameters.append(name = "apikey", value = apiKey)
            }
        }.body<AlphaVantageQuote>()
        httpClient.close()
        return response
    }
}

private const val ALPHA_VANTAGE_URL = "www.alphavantage.co"
