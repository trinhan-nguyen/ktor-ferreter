package com.ferreter

import com.ferreter.client.api.AlphaVantageApi
import com.ferreter.di.configureKoin
import com.ferreter.plugins.configureRouting
import com.ferreter.plugins.configureSerialization
import com.ferreter.plugins.configureStatusPages
import io.ktor.server.application.*
import org.koin.ktor.ext.inject

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module(isProduction: Boolean = true) {
    if (isProduction) {
        configureKoin()
    }

    configureSerialization()
    configureStatusPages()

    val alphaVantageApi by inject<AlphaVantageApi>()
    configureRouting(alphaVantageApi = alphaVantageApi)
}
