package com.example.myapplication.day8.products.repo

import com.example.myapplication.day8.dto.Product
import com.example.myapplication.day8.dto.ProductsResponse
import retrofit2.Response

interface ProductsRepository {

    suspend fun getAllProductsFromRemoteDataSource(): Response<ProductsResponse>

    suspend fun insert(product: Product)
}