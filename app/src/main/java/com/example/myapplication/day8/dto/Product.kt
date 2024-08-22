package com.example.myapplication.day8.dto

import androidx.annotation.Nullable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class Product(
    @ColumnInfo(name = "availability_status")
    val availabilityStatus: String,
//    val brand: String,
    val category: String,
    val description: String,
//    val dimensions: Dimensions,
    val discountPercentage: Double,
    @PrimaryKey
    val id: Int,
//    val images: List<String>,
//    val meta: Meta,
    val minimumOrderQuantity: Int,
    val price: Double,
    val rating: Double,
    val returnPolicy: String,
//    val reviews: List<Review>,
    val shippingInformation: String,
    val sku: String,
    val stock: Int,
//    val tags: List<String>,
    val thumbnail: String,
    val title: String,
    val warrantyInformation: String,
    val weight: Int
)