package com.ferreter.plugins

import com.ferreter.client.api.AlphaVantageApi
import com.ferreter.routes.simpleStockQuoteRoute
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting(
    alphaVantageApi: AlphaVantageApi,
) {
    val apiKey = environment.config.propertyOrNull(KTOR_ENV)?.getString()
    routing {
        simpleStockQuoteRoute(apiKey, alphaVantageApi)
    }
}

private const val KTOR_ENV = "ktor.environment"
