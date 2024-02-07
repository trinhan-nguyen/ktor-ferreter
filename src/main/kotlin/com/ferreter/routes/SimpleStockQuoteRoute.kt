package com.ferreter.routes

import com.ferreter.client.api.AlphaVantageApi
import com.ferreter.client.models.ErrorMessage
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.simpleStockQuoteRoute(
    apiKey: String?,
    alphaVantageApi: AlphaVantageApi,
) {
    get("/quote/{$SYMBOL_PARAM}") {
        val tickerSymbol = call.parameters[SYMBOL_PARAM]
        if (apiKey != null && tickerSymbol != null) {
            val quote = alphaVantageApi.getQuote(
                symbol = tickerSymbol,
                apiKey = apiKey,
            )
            call.respond(quote)
        } else {
            call.respond(
                ErrorMessage(errorMessage = "Failed to get the API key!")
            )
        }
    }
}

private const val SYMBOL_PARAM = "symbol"
