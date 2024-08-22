package com.example.myapplication.day8.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.myapplication.day8.dto.Product

@Dao
interface ProductDao {

    @Query("SELECT * FROM products")
    fun getAllLocalProducts(): List<Product>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg product: Product)

    @Update
    suspend fun update(product: Product)

    @Delete
    suspend fun delete(product: Product)
}