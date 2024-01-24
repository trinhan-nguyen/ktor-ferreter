package com.ferreter.di

import com.ferreter.client.api.AlphaVantageApi
import com.ferreter.client.api.AlphaVantageApiImpl
import com.ferreter.client.api.AlphaVantageQuoteToSimpleStockQuoteMapper
import com.ferreter.client.api.AlphaVantageQuoteToSimpleStockQuoteMapperImpl
import org.koin.dsl.module

val applicationModule = module {
    single<AlphaVantageQuoteToSimpleStockQuoteMapper> {
        AlphaVantageQuoteToSimpleStockQuoteMapperImpl()
    }

    single<AlphaVantageApi> {
        AlphaVantageApiImpl(get())
    }
}
