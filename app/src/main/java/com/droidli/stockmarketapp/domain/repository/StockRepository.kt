package com.droidli.stockmarketapp.domain.repository

import com.droidli.stockmarketapp.domain.model.CompanyInfo
import com.droidli.stockmarketapp.domain.model.CompanyListing
import com.droidli.stockmarketapp.domain.model.IntradayInfo
import com.droidli.stockmarketapp.util.Resource
import kotlinx.coroutines.flow.Flow

interface StockRepository {

    suspend fun getCompanyListings(
        fetchFromRemote: Boolean,
        query:String
    ): Flow<Resource<List<CompanyListing>>>

    suspend fun getIntradayInfo(
        symbol:String
    ): Resource<List<IntradayInfo>>

    suspend fun getCompanyInfo(
        symbol: String
    ): Resource<CompanyInfo>
}