package com.ferreter.routes

import com.ferreter.client.api.AlphaVantageApi
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.simpleStockQuoteRoute(
    apiKey: String?,
    alphaVantageApi: AlphaVantageApi,
) {
    get("/quote") {
        apiKey?.let {
            val quote = alphaVantageApi.getQuote(
                symbol = "IBM",
                apiKey = apiKey,
            )
            call.respond(quote)
        } ?: call.respond("Failed to get the API key!")
    }
}
