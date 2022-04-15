package com.droidli.stockmarketapp.di

import com.droidli.stockmarketapp.data.csv.CSVParser
import com.droidli.stockmarketapp.data.csv.CompanyListingParser
import com.droidli.stockmarketapp.data.repository.StockRepositoryImpl
import com.droidli.stockmarketapp.domain.model.CompanyListing
import com.droidli.stockmarketapp.domain.model.IntradayInfo
import com.droidli.stockmarketapp.domain.repository.StockRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCompanyListingsParser(
        companyListingsParser: CompanyListingParser
    ): CSVParser<CompanyListing>

    @Binds
    @Singleton
    abstract fun bindIntradayInfoParser(
        intradayInfoParser: IntradayInfo
    ): CSVParser<IntradayInfo>

    @Binds
    @Singleton
    abstract fun bindStockRepository(
        stockRepositoryImpl: StockRepositoryImpl
    ): StockRepository
}