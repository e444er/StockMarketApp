package com.droidli.stockmarketapp.domain.repository

import com.droidli.stockmarketapp.domain.model.CompanyListing
import com.droidli.stockmarketapp.util.Resource
import kotlinx.coroutines.flow.Flow

interface StockRepository {

    suspend fun getCompanyListings(
        fetchFromRemote: Boolean,
        query:String
    ): Flow<Resource<List<CompanyListing>>>
}