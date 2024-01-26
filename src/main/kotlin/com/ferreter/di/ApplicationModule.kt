package com.ferreter.di

import com.ferreter.client.api.AlphaVantageApi
import com.ferreter.client.api.AlphaVantageApiImpl
import com.ferreter.client.api.SimpleStockQuoteMapper
import com.ferreter.client.api.SimpleStockQuoteMapperImpl
import org.koin.dsl.module

val applicationModule = module {
    single<SimpleStockQuoteMapper> {
        SimpleStockQuoteMapperImpl()
    }

    single<AlphaVantageApi> {
        AlphaVantageApiImpl(get())
    }
}
