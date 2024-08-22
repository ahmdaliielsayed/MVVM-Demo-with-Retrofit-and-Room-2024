package com.example.myapplication.day8.network

import com.example.myapplication.day8.dto.ProductsResponse
import retrofit2.Response

object APIClient : RemoteDataSource {

    override suspend fun getAllProductsFromRemoteDataSource(): Response<ProductsResponse> {
        return API.retrofitService.getAllProducts()
    }
}