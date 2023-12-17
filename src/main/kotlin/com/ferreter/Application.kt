package com.ferreter

import com.ferreter.plugins.configureRouting
import com.ferreter.plugins.configureSerialization
import com.ferreter.plugins.configureStatusPages
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureSerialization()
    configureStatusPages()
    configureRouting()
}
