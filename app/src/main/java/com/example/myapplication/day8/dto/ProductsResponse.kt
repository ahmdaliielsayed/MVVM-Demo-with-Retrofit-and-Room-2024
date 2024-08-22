package com.example.myapplication.day8.dto

import com.google.gson.annotations.SerializedName

data class ProductsResponse(
    val limit: Int,
    @SerializedName("products")
    val productsList: List<Product>,
    val skip: Int,
    val total: Int
)