package com.example.myapplication.day8.network

import com.example.myapplication.day8.dto.Product
import com.example.myapplication.day8.dto.ProductsResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

/*
* https://dummyjson.com/products
* https://dummyjson.com/products/id
* https://dummyjson.com/products/search?q=query
* https://dummyjson.com/products/search?q=Essence%20Mascara%20Lash%20Princess
* https://dummyjson.com/products/add
* */
interface APIService {
    @GET("products")
    suspend fun getAllProducts(): Response<ProductsResponse>

    @GET("products/{productId}")
    suspend fun getProductBy(
        @Path("productId") id: String
    ): Product

    @GET("products/search")
    suspend fun search(
        @Query("q") search: String
    ): ProductsResponse

    @POST("products/add")
    suspend fun add(
        @Body product: Product
    ): Product
}