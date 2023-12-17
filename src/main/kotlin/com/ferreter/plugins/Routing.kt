package com.ferreter.plugins

import com.ferreter.Response
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    handleError()

    routing {
        get("/") {
            call.respond(Response(status = "OK"))
        }
    }
}

private fun Application.handleError() {
    install(StatusPages) {
        exception<Throwable> { call, error ->
            call.respondText(
                text = error.localizedMessage,
                contentType = ContentType.Text.Plain,
                status = HttpStatusCode.InternalServerError,
            )
        }
    }
}
