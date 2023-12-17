package com.ferreter.plugins

import com.ferreter.Response
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    val apiKey = environment.config.propertyOrNull(KTOR_ENV)?.getString()
    routing {
        get("/") {
            apiKey?.let {
                call.respond(Response(it))
            } ?: call.respond(Response("Failed to get API key!"))
        }
    }
}

private const val KTOR_ENV = "ktor.environment"