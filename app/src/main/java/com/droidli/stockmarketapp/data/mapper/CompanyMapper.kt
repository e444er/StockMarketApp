package com.droidli.stockmarketapp.data.mapper

import com.droidli.stockmarketapp.data.local.CompanyListingEntity
import com.droidli.stockmarketapp.data.remote.dto.CompanyInfoDto
import com.droidli.stockmarketapp.domain.model.CompanyInfo
import com.droidli.stockmarketapp.domain.model.CompanyListing

fun CompanyListingEntity.toCompanyListing(): CompanyListing {
    return CompanyListing(
        name = name,
        symbol = symbol,
        exchange = exchange
    )
}

fun CompanyListing.toCompanyListingEntity(): CompanyListingEntity {
    return CompanyListingEntity(
        name = name,
        symbol = symbol,
        exchange = exchange
    )
}

fun CompanyInfoDto.toCompanyInfo(): CompanyInfo{
    return CompanyInfo(
        symbol, description, name, country, industry
    )
}