package com.example.myapplication.day8.db

import android.content.Context
import com.example.myapplication.day8.dto.Product

class LocalDataSourceImpl(context: Context) : LocalDataSource {

    private var dao: ProductDao

    init {
        val db = ProductDatabase.getInstance(context)
        dao = db.productDao()
    }

    override suspend fun insert(product: Product) {
        dao.insert(product)
    }
}