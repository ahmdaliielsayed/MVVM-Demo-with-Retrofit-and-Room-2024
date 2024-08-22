package com.example.myapplication.day8.network

import com.example.myapplication.day8.dto.ProductsResponse
import retrofit2.Response

interface RemoteDataSource {

    suspend fun getAllProductsFromRemoteDataSource(): Response<ProductsResponse>
}