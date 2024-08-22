package com.example.myapplication.day8.products.repo

import com.example.myapplication.day8.db.LocalDataSource
import com.example.myapplication.day8.dto.Product
import com.example.myapplication.day8.dto.ProductsResponse
import com.example.myapplication.day8.network.RemoteDataSource
import retrofit2.Response

class ProductsRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
): ProductsRepository {

    /*
    * Dependency Injection
    * 1. Koin
    * 2. Dagger2
    * 3. Hilt
    * */

    /*
    * Remote Data Source
    * Local Data Source (SQLite - Realm - Room)
    * Mocking Data Source
    * */

    /*
    * Don't depend on CONCRETE type, ALWAYS depend on ABSTRACT type
    * Don't HIDE dependency
    * */

    override suspend fun getAllProductsFromRemoteDataSource(): Response<ProductsResponse> {
        return remoteDataSource.getAllProductsFromRemoteDataSource()
    }

    override suspend fun insert(product: Product) {
        localDataSource.insert(product)
    }
}