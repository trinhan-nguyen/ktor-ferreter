package com.ferreter.client.api

import com.ferreter.client.models.AlphaVantageQuote
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class AlphaVantageApiImpl : AlphaVantageApi {
    override suspend fun getQuote(
        symbol: String,
        apiKey: String,
    ): AlphaVantageQuote {
        val httpClient = HttpClient {
            install(ContentNegotiation) {
                json(
                    Json {
                        prettyPrint = true
                        isLenient = true
                        ignoreUnknownKeys = true
                    }
                )
            }
        }
        val response = httpClient.get {
            url {
                protocol = URLProtocol.HTTPS
                host = ALPHA_VANTAGE_URL
                path("query")
                parameters.append(name = "function", value = "GLOBAL_QUOTE")
                parameters.append(name = "symbol", value = symbol)
                parameters.append(name = "apikey", value = apiKey)
            }
        }
        httpClient.close()
        return response.body<AlphaVantageQuote>()
    }
}

private const val ALPHA_VANTAGE_URL = "www.alphavantage.co"
