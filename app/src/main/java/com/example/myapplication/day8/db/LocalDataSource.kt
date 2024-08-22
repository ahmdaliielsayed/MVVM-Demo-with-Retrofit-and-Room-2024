package com.example.myapplication.day8.db

import com.example.myapplication.day8.dto.Product

interface LocalDataSource {

    suspend fun insert(product: Product)
}