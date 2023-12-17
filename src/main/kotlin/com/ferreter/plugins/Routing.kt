package com.ferreter.plugins

import com.ferreter.Response
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respond(Response(status = "OK"))
        }
    }
}
