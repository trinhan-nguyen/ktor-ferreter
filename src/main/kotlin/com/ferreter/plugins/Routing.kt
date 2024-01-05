package com.ferreter.plugins

import com.ferreter.Response
import com.ferreter.client.api.AlphaVantageApiImpl
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    val apiKey = environment.config.propertyOrNull(KTOR_ENV)?.getString()
    val api = AlphaVantageApiImpl()
    routing {
        get("/") {
            apiKey?.let {
                val quote = api.getQuote(
                    symbol = "IBM",
                    apiKey = apiKey,
                )
                call.respond(quote)
            } ?: call.respond(Response("Failed to get API key!"))
        }
    }
}

private const val KTOR_ENV = "ktor.environment"
