package com.ferreter.plugins

import com.ferreter.client.api.AlphaVantageApi
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting(
    alphaVantageApi: AlphaVantageApi
) {
    val apiKey = environment.config.propertyOrNull(KTOR_ENV)?.getString()
    routing {
        get("/") {
            apiKey?.let {
                val quote = alphaVantageApi.getQuote(
                    symbol = "IBM",
                    apiKey = apiKey,
                )
                call.respond(quote)
            } ?: call.respond("Failed to get the API key!")
        }
    }
}

private const val KTOR_ENV = "ktor.environment"
