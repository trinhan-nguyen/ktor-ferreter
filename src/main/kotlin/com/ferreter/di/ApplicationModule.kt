package com.ferreter.di

import com.ferreter.client.api.AlphaVantageApi
import com.ferreter.client.api.AlphaVantageApiImpl
import org.koin.dsl.module

val applicationModule = module {
    single<AlphaVantageApi> {
        AlphaVantageApiImpl()
    }
}
