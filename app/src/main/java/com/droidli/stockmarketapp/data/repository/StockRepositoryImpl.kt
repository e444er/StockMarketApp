package com.droidli.stockmarketapp.data.repository

import com.droidli.stockmarketapp.data.local.StockDatabase
import com.droidli.stockmarketapp.data.mapper.toCompanyListing
import com.droidli.stockmarketapp.data.remote.StockApi
import com.droidli.stockmarketapp.domain.model.CompanyListing
import com.droidli.stockmarketapp.domain.repository.StockRepository
import com.droidli.stockmarketapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StockRepositoryImpl @Inject constructor(
    val api: StockApi,
    val db: StockDatabase
) : StockRepository {

    private val dao = db.dao

    override suspend fun getCompanyListings(
        fetchFromRemote: Boolean,
        query: String
    ): Flow<Resource<List<CompanyListing>>> {
        return flow {
            emit(Resource.Loading(true))
            val localListing = dao.searchCompanyListing(query = query)
            emit(Resource.Success(
                data = localListing.map { it.toCompanyListing() }
            ))

            val isDbEmpty = localListing.isEmpty() && query.isBlank()
            val shouldJustLoadFromCache = !isDbEmpty && !fetchFromRemote
            if (shouldJustLoadFromCache) {
                emit(Resource.Loading(false))
                return@flow
            }
            val remoteListings = try{
                val response = api.getListings()

            }catch (e: IOException){
                e.printStackTrace()
                emit(Resource.Error("Couldn't load data"))
            }catch (e:HttpException) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't load data"))
            }
        }
    }

}